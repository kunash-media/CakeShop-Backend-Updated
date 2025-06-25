package com.cs.cakeshop.service;

import com.cs.cakeshop.Dto.request.DiscountRequestDto;
import com.cs.cakeshop.Dto.response.DiscountResponseDto;

import java.util.List;

public interface DiscountService {
    DiscountResponseDto createDiscount(DiscountRequestDto requestDto);
    DiscountResponseDto getDiscountById(Long id);
    DiscountResponseDto getDiscountByCode(String code);
    List<DiscountResponseDto> getAllDiscounts();
    List<DiscountResponseDto> getDiscountsByStatus(String status);
    List<DiscountResponseDto> getDiscountsByType(String type);
    DiscountResponseDto updateDiscount(Long id, DiscountRequestDto requestDto);
    void deleteDiscount(Long id);
}
