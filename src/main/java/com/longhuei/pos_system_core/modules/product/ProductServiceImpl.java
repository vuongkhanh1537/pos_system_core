package com.longhuei.pos_system_core.modules.product;

import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.product.dto.ProductCreateRequest;
import com.longhuei.pos_system_core.modules.product.dto.ProductUpdateRequest;
import com.longhuei.pos_system_core.utils.Const;
import com.longhuei.pos_system_core.utils.StatusCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public BaseResponse create(ProductCreateRequest request) {
        Product product = productMapper.toEntity(request);
        this.productRepository.save(product);
        return new BaseResponse<>();
    }

    public BaseResponse update(String id, ProductUpdateRequest request) {
        Product product = this.productRepository.findById(id)
            .orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_CODE_NOT_EXISTED));
        this.productMapper.update(product, request);
        this.productRepository.save(product);
        return new BaseResponse<>();
    }

    public BaseResponse delete(String id) {
        this.productRepository.findById(id).ifPresentOrElse(
            product -> {
                product.setDeleted(Const.ACTIVE);
                this.productRepository.save(product);
        }, () -> new ApplicationException(ErrorCode.PRODUCT_NOT_EXISTED));
        return new BaseResponse<>();
    }
}
