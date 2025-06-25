package com.cs.cakeshop.service;

import com.cs.cakeshop.Dto.request.ProductReviewRequestDto;
import com.cs.cakeshop.Dto.response.ProductReviewResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductReviewService {
    ProductReviewResponseDto createReview(ProductReviewRequestDto requestDto,
                                          List<MultipartFile> customerImages,
                                          MultipartFile customerUploadedImage);
    ProductReviewResponseDto getReviewById(Long id);
    List<ProductReviewResponseDto> getAllReviews();
    ProductReviewResponseDto updateReview(Long id, ProductReviewRequestDto requestDto,
                                          List<MultipartFile> customerImages,
                                          MultipartFile customerUploadedImage);
    void deleteReview(Long id);
    List<ProductReviewResponseDto> getReviewsByCustomerName(String customerName);
    List<ProductReviewResponseDto> getReviewsByRating(Integer rating);
}

