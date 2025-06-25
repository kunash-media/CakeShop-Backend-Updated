package com.cs.cakeshop.service.serviceImpl;

import com.cs.cakeshop.Dto.request.ProductReviewRequestDto;
import com.cs.cakeshop.Dto.response.ProductReviewResponseDto;
import com.cs.cakeshop.entity.ProductReviewEntity;
import com.cs.cakeshop.repository.ProductReviewRepository;
import com.cs.cakeshop.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    private ProductReviewRepository reviewRepository;

    @Override
    public ProductReviewResponseDto createReview(ProductReviewRequestDto requestDto,
                                                 List<MultipartFile> customerImages,
                                                 MultipartFile customerUploadedImage) {
        ProductReviewEntity entity = new ProductReviewEntity();
        mapDtoToEntity(requestDto, entity);

        try {
            if (customerImages != null && !customerImages.isEmpty()) {
                StringBuilder imageData = new StringBuilder();
                for (MultipartFile image : customerImages) {
                    if (!image.isEmpty()) {
                        imageData.append(Base64.getEncoder().encodeToString(image.getBytes())).append(",");
                    }
                }
                entity.setCustomerImages(imageData.toString().getBytes());
            }

            if (customerUploadedImage != null && !customerUploadedImage.isEmpty()) {
                entity.setCustomerUploadedImage(customerUploadedImage.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing images", e);
        }

        ProductReviewEntity savedEntity = reviewRepository.save(entity);
        return mapEntityToDto(savedEntity);
    }

    @Override
    public ProductReviewResponseDto getReviewById(Long id) {
        ProductReviewEntity entity = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
        return mapEntityToDto(entity);
    }

    @Override
    public List<ProductReviewResponseDto> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductReviewResponseDto updateReview(Long id, ProductReviewRequestDto requestDto,
                                                 List<MultipartFile> customerImages,
                                                 MultipartFile customerUploadedImage) {
        ProductReviewEntity entity = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));

        mapDtoToEntity(requestDto, entity);

        try {
            if (customerImages != null && !customerImages.isEmpty()) {
                StringBuilder imageData = new StringBuilder();
                for (MultipartFile image : customerImages) {
                    if (!image.isEmpty()) {
                        imageData.append(Base64.getEncoder().encodeToString(image.getBytes())).append(",");
                    }
                }
                entity.setCustomerImages(imageData.toString().getBytes());
            }

            if (customerUploadedImage != null && !customerUploadedImage.isEmpty()) {
                entity.setCustomerUploadedImage(customerUploadedImage.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing images", e);
        }

        ProductReviewEntity updatedEntity = reviewRepository.save(entity);
        return mapEntityToDto(updatedEntity);
    }

    @Override
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ProductReviewResponseDto> getReviewsByCustomerName(String customerName) {
        return reviewRepository.findByCustomerName(customerName).stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductReviewResponseDto> getReviewsByRating(Integer rating) {
        return reviewRepository.findByRatings(rating).stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    private void mapDtoToEntity(ProductReviewRequestDto dto, ProductReviewEntity entity) {
        entity.setTotalRatings(dto.getTotalRatings());
        entity.setCustomerName(dto.getCustomerName());
        entity.setApproval(dto.getApproval());
        entity.setRatings(dto.getRatings());
        entity.setDate(dto.getDate());
        entity.setPlace(dto.getPlace());
        entity.setOccasion(dto.getOccasion());
        entity.setCustomerFeedback(dto.getCustomerFeedback());
    }

    private ProductReviewResponseDto mapEntityToDto(ProductReviewEntity entity) {
        ProductReviewResponseDto dto = new ProductReviewResponseDto();
        dto.setId(entity.getId());
        dto.setTotalRatings(entity.getTotalRatings());
        dto.setCustomerName(entity.getCustomerName());
        dto.setApproval(entity.getApproval());
        dto.setRatings(entity.getRatings());
        dto.setDate(entity.getDate());
        dto.setPlace(entity.getPlace());
        dto.setOccasion(entity.getOccasion());
        dto.setCustomerFeedback(entity.getCustomerFeedback());

        if (entity.getCustomerImages() != null) {
            String imageData = new String(entity.getCustomerImages());
            if (!imageData.isEmpty()) {
                dto.setCustomerImages(Arrays.asList(imageData.split(",")));
            }
        }

        if (entity.getCustomerUploadedImage() != null) {
            dto.setCustomerUploadedImage(Base64.getEncoder().encodeToString(entity.getCustomerUploadedImage()));
        }

        return dto;
    }
}

