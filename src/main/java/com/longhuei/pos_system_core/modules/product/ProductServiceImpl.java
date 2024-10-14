package com.longhuei.pos_system_core.modules.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.dto.PageResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.product.dto.ProductCreateRequest;
import com.longhuei.pos_system_core.modules.product.dto.ProductResponse;
import com.longhuei.pos_system_core.modules.product.dto.ProductSearchRequest;
import com.longhuei.pos_system_core.modules.product.dto.ProductUpdateRequest;
import com.longhuei.pos_system_core.modules.productCodeGen.services.CoatingService;
import com.longhuei.pos_system_core.modules.productCodeGen.services.ColorService;
import com.longhuei.pos_system_core.modules.productCodeGen.services.GraphicService;
import com.longhuei.pos_system_core.modules.productCodeGen.services.LabelService;
import com.longhuei.pos_system_core.modules.productCodeGen.services.ModelService;
import com.longhuei.pos_system_core.modules.productCodeGen.services.SizeService;
import com.longhuei.pos_system_core.utils.Const;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final LabelService labelService;
    private final ModelService modelService;
    private final CoatingService coatingService;
    private final ColorService colorService;
    private final SizeService sizeService;
    private final GraphicService graphicService;

    @Override
    public BaseResponse create(ProductCreateRequest request) {
        Product product = productMapper.toEntity(request);
        product = mappingProductCodeProperties(product, request);
        if (isProductCodeAvailable(product.getProductCode())) {
            throw new ApplicationException(ErrorCode.PRODUCT_EXISTED);
        }
        this.productRepository.save(product);
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse update(String id, ProductUpdateRequest request) {
        Product product = this.productRepository.findById(id)
            .orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_NOT_EXISTED));
        this.productMapper.update(product, request);
        this.productRepository.save(product);
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse delete(String id) {
        this.productRepository.findById(id).ifPresentOrElse(
            product -> {
                product.setDeleted(Const.ACTIVE);
                this.productRepository.save(product);
        }, () -> new ApplicationException(ErrorCode.PRODUCT_NOT_EXISTED));
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse search(ProductSearchRequest request, Pageable pageable) {
        BaseResponse<PageResponse<ProductResponse>> response = new BaseResponse<>();
        Page<ProductResponse> productResponses = this.productRepository.search(request.getKeyword(), pageable);
        response.setWsResponse(new PageResponse<ProductResponse>(productResponses));
        return response;
    }

    @Override
    public BaseResponse checkProductCodeAvailable(String id) {
        if (isProductCodeAvailable(id)) {
            throw new ApplicationException(ErrorCode.PRODUCT_EXISTED);
        }
        return new BaseResponse<>();
    }

    private boolean isProductCodeAvailable(String id) {
        return this.productRepository.existsById(id);
    }

    private Product mappingProductCodeProperties(Product product, ProductCreateRequest request) {
        product.setLabelCode(labelService.findById(request.getLabelCode()));
        product.setModelCode(modelService.findById(request.getModelCode()));
        product.setCoatingCode(coatingService.findById(request.getCoatingCode()));
        product.setColorCode(colorService.findById(request.getColorCode()));
        product.setSizeCode(sizeService.findById(request.getSizeCode()));
        product.setGraphicCode(graphicService.findById(request.getGraphicCode()));

        return product;
    }
}
