package com.longhuei.pos_system_core.modules.productPrices;

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

        for (PriceListItemDTO itemDTO : request.getPrices()) {
            PriceListItem item = priceListItemMapper.toEntity(itemDTO);
            item.setPriceList(priceList);
            priceList.getPrices().add(item);
        }

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
        priceList.getPrices().stream().forEach(
            item -> item.setDeleted(Const.ACTIVE)
        );
        for (PriceListItemDTO itemDTO : request.getPrices()) {
            if (itemDTO.getId() == null) {
                PriceListItem item = priceListItemMapper.toEntity(itemDTO);
                item.setPriceList(priceList);
                priceList.getPrices().add(item);
            } else {
                PriceListItem item = priceListItemRepository.findById(itemDTO.getId()).orElseThrow(
                    () -> new ApplicationException(ErrorCode.NOT_FOUND)
                );
                priceListItemMapper.update(item, itemDTO);
                item.setDeleted(Const.INACTIVE);
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
        for (PriceListItem item : priceList.getPrices()) {
            Product product = item.getProduct();
            product.setCurrentPriceListItemId(item.getId());
            productRepository.save(product);
        }
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse getDetail(String id) {
        PriceList priceList = priceListRepository.findById(id).orElseThrow(
            () -> new ApplicationException(ErrorCode.NOT_FOUND)
        );
        PriceListDTO dto = priceListMapper.toDTO(priceList);
        return new BaseResponse<>(dto);
    }

    private String generatePriceListId() {
        PriceListSequence sequence = sequenceRepository.getSequenceForUpdate();
        Integer nextVal = sequence.getNextVal();
        sequence.setNextVal(nextVal + 1);
        sequenceRepository.save(sequence);
        
        return String.format("PL%04d", nextVal);
    }
}
