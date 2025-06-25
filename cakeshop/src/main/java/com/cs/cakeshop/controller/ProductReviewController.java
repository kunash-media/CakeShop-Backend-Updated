package com.cs.cakeshop.controller;

import com.cs.cakeshop.Dto.request.ProductReviewRequestDto;
import com.cs.cakeshop.Dto.response.ProductReviewResponseDto;
import com.cs.cakeshop.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ProductReviewController {

    @Autowired
    private ProductReviewService reviewService;

    @PostMapping("/create-review")
    public ResponseEntity<ProductReviewResponseDto> createReview(
            @RequestPart("review") ProductReviewRequestDto requestDto,
            @RequestPart(value = "customerImages", required = false) List<MultipartFile> customerImages,
            @RequestPart(value = "customerUploadedImage", required = false) MultipartFile customerUploadedImage) {

        ProductReviewResponseDto response = reviewService.createReview(requestDto, customerImages, customerUploadedImage);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductReviewResponseDto> getReviewById(@PathVariable Long id) {
        ProductReviewResponseDto response = reviewService.getReviewById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductReviewResponseDto>> getAllReviews() {
        List<ProductReviewResponseDto> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductReviewResponseDto> updateReview(
            @PathVariable Long id,
            @RequestPart("review") ProductReviewRequestDto requestDto,
            @RequestPart(value = "customerImages", required = false) List<MultipartFile> customerImages,
            @RequestPart(value = "customerUploadedImage", required = false) MultipartFile customerUploadedImage) {

        ProductReviewResponseDto response = reviewService.updateReview(id, requestDto, customerImages, customerUploadedImage);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerName}")
    public ResponseEntity<List<ProductReviewResponseDto>> getReviewsByCustomerName(@PathVariable String customerName) {
        List<ProductReviewResponseDto> reviews = reviewService.getReviewsByCustomerName(customerName);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ProductReviewResponseDto>> getReviewsByRating(@PathVariable Integer rating) {
        List<ProductReviewResponseDto> reviews = reviewService.getReviewsByRating(rating);
        return ResponseEntity.ok(reviews);
    }
}
