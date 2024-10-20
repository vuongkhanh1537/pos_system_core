package com.longhuei.pos_system_core.modules.productPrices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.product.Product;
import com.longhuei.pos_system_core.modules.product.ProductRepository;
import com.longhuei.pos_system_core.modules.productPrices.dto.PriceListDTO;
import com.longhuei.pos_system_core.modules.productPrices.dto.PriceListItemDTO;
import com.longhuei.pos_system_core.modules.productPrices.dto.PriceSearchRequest;
import com.longhuei.pos_system_core.modules.productPrices.mapper.PriceListItemMapper;
import com.longhuei.pos_system_core.modules.productPrices.mapper.PriceListMapper;
import com.longhuei.pos_system_core.modules.productPrices.models.PriceList;
import com.longhuei.pos_system_core.modules.productPrices.models.PriceListItem;
import com.longhuei.pos_system_core.modules.productPrices.models.PriceListSequence;
import com.longhuei.pos_system_core.modules.productPrices.repository.PriceListItemRepository;
import com.longhuei.pos_system_core.modules.productPrices.repository.PriceListRepository;
import com.longhuei.pos_system_core.modules.productPrices.repository.PriceListSequenceRepository;
import com.longhuei.pos_system_core.utils.Const;
import com.longhuei.pos_system_core.utils.enums.CommonStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceListServiceImpl implements PriceListService {
    
    private final PriceListRepository priceListRepository;
    private final PriceListItemRepository priceListItemRepository;
    private final PriceListMapper priceListMapper;
    private final PriceListItemMapper priceListItemMapper;
    private final PriceListSequenceRepository sequenceRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public BaseResponse<?> create(PriceListDTO request) {
        PriceList priceList = priceListMapper.toEntity(request);
        priceList.setId(generatePriceListId());
        priceList.setStatus(CommonStatus.DRAFT);

        List<PriceListItem> items = new ArrayList<>();
        for (PriceListItemDTO itemDTO : request.getPrices()) {
            PriceListItem item = priceListItemMapper.toEntity(itemDTO);
            item.setProduct(productRepository.findById(itemDTO.getProductId()).orElseThrow(
                () -> new ApplicationException(ErrorCode.PRODUCT_NOT_EXISTED)
            ));
            item.setPriceList(priceList);
            items.add(item);
        }
        priceList.setPrices(items);

        priceListRepository.save(priceList);

        return new BaseResponse<>();
    }

    @Override
    @Transactional
    public BaseResponse update(PriceListDTO request) {
        PriceList priceList = priceListRepository.findById(request.getId()).orElseThrow(
                () -> new ApplicationException(ErrorCode.NOT_FOUND)
        );

        priceListMapper.update(priceList, request);
        priceList.getPrices().stream().forEach(item -> item.setDeleted(Const.ACTIVE));
        
        Map<Long, PriceListItem> itemMap = priceList.getPrices().stream()
            .collect(Collectors.toMap(PriceListItem::getId, item -> item));

        for (PriceListItemDTO itemDTO : request.getPrices()) { 
            if (itemDTO.getId() == null) {
                PriceListItem item = priceListItemMapper.toEntity(itemDTO);
                item.setProduct(productRepository.findById(itemDTO.getProductId()).orElseThrow(
                () -> new ApplicationException(ErrorCode.PRODUCT_NOT_EXISTED)
                ));
                item.setPriceList(priceList);
                priceList.getPrices().add(item);
            } else {
                PriceListItem item = itemMap.get(itemDTO.getId());
                if (item != null) {
                    priceListItemMapper.update(item, itemDTO);
                    item.setDeleted(Const.INACTIVE);
                }
            }
        }
        this.priceListRepository.save(priceList);
        return new BaseResponse<>();
    }

    @Override
    @Transactional
    public BaseResponse delete(String id) {
        PriceList priceList = priceListRepository.findById(id).orElseThrow(
            () -> new ApplicationException(ErrorCode.NOT_FOUND)
        );
        priceList.setDeleted(Const.ACTIVE);
        priceListRepository.save(priceList);
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse search(PriceSearchRequest request, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional
    public BaseResponse active(String id) {
        PriceList priceList = priceListRepository.findById(id).orElseThrow(
            () -> new ApplicationException(ErrorCode.NOT_FOUND)
        );
        priceList.setStatus(CommonStatus.COMPLETED);
        List<Product> products = new ArrayList<>();
        for (PriceListItem item : priceList.getPrices()) {
            if (!item.isDeleted()) {
                Product product = item.getProduct();
                product.setCurrentPriceListItemId(item.getId());
                products.add(product);
            }
        }
        productRepository.saveAll(products);
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse getDetail(String id) {
        PriceList priceList = priceListRepository.findById(id).orElseThrow(
            () -> new ApplicationException(ErrorCode.NOT_FOUND)
        );
        PriceListDTO dto = priceListMapper.toDTO(priceList);
        dto.setPrices(priceList.getPrices().stream()
            .filter(item -> !item.isDeleted())
            .map(item -> {
                PriceListItemDTO itemDTO = priceListItemMapper.toDTO(item);
                itemDTO.setProductId(item.getProduct().getProductId());
                return itemDTO;
            })
            .toList()
        );
        return new BaseResponse<>(dto);
    }

    private String generatePriceListId() {
        PriceListSequence sequence = sequenceRepository.getSequenceForUpdate();
        if (sequence == null) {
            sequence = new PriceListSequence();
            sequence.setNextVal(1);
        }
        Integer nextVal = sequence.getNextVal();
        sequence.setNextVal(nextVal + 1);
        sequenceRepository.save(sequence);
        
        return String.format("PL%04d", nextVal);
    }
}
