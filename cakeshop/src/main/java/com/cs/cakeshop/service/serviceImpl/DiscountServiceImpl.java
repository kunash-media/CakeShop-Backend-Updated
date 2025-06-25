package com.cs.cakeshop.service.serviceImpl;

import com.cs.cakeshop.Dto.request.DiscountRequestDto;
import com.cs.cakeshop.Dto.response.DiscountResponseDto;
import com.cs.cakeshop.entity.DiscountEntity;
import com.cs.cakeshop.repository.DiscountRepository;
import com.cs.cakeshop.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public DiscountResponseDto createDiscount(DiscountRequestDto requestDto) {
        DiscountEntity entity = mapToEntity(requestDto);
        DiscountEntity savedEntity = discountRepository.save(entity);
        return mapToResponseDto(savedEntity);
    }

    @Override
    public DiscountResponseDto getDiscountById(Long id) {
        DiscountEntity entity = discountRepository.findById(id).orElse(null);
        return entity != null ? mapToResponseDto(entity) : null;
    }

    @Override
    public DiscountResponseDto getDiscountByCode(String code) {
        DiscountEntity entity = discountRepository.findByDiscountCode(code).orElse(null);
        return entity != null ? mapToResponseDto(entity) : null;
    }

    @Override
    public List<DiscountResponseDto> getAllDiscounts() {
        return discountRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiscountResponseDto> getDiscountsByStatus(String status) {
        return discountRepository.findByStatus(status).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiscountResponseDto> getDiscountsByType(String type) {
        return discountRepository.findByDiscountType(type).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public DiscountResponseDto updateDiscount(Long id, DiscountRequestDto requestDto) {
        DiscountEntity existingEntity = discountRepository.findById(id).orElse(null);
        if (existingEntity != null) {
            updateEntityFromDto(existingEntity, requestDto);
            DiscountEntity updatedEntity = discountRepository.save(existingEntity);
            return mapToResponseDto(updatedEntity);
        }
        return null;
    }

    @Override
    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }

    private DiscountEntity mapToEntity(DiscountRequestDto dto) {
        DiscountEntity entity = new DiscountEntity();
        entity.setDiscountCode(dto.getDiscountCode());
        entity.setDescription(dto.getDescription());
        entity.setDiscountType(dto.getDiscountType());
        entity.setDiscountValue(dto.getDiscountValue());
        entity.setMinimumOrderAmount(dto.getMinimumOrderAmount());
        entity.setMaximumDiscountAmount(dto.getMaximumDiscountAmount());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setApplicabilityType(dto.getApplicabilityType());
        entity.setCategories(dto.getCategories());
        entity.setUsageLimit(dto.getUsageLimit());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    private DiscountResponseDto mapToResponseDto(DiscountEntity entity) {
        return new DiscountResponseDto(
                entity.getId(),
                entity.getDiscountCode(),
                entity.getDescription(),
                entity.getDiscountType(),
                entity.getDiscountValue(),
                entity.getMinimumOrderAmount(),
                entity.getMaximumDiscountAmount(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getApplicabilityType(),
                entity.getCategories(),
                entity.getUsageLimit(),
                entity.getStatus()
        );
    }

    private void updateEntityFromDto(DiscountEntity entity, DiscountRequestDto dto) {
        entity.setDiscountCode(dto.getDiscountCode());
        entity.setDescription(dto.getDescription());
        entity.setDiscountType(dto.getDiscountType());
        entity.setDiscountValue(dto.getDiscountValue());
        entity.setMinimumOrderAmount(dto.getMinimumOrderAmount());
        entity.setMaximumDiscountAmount(dto.getMaximumDiscountAmount());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setApplicabilityType(dto.getApplicabilityType());
        entity.setCategories(dto.getCategories());
        entity.setUsageLimit(dto.getUsageLimit());
        entity.setStatus(dto.getStatus());
    }
}
