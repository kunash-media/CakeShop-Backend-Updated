package com.cs.cakeshop.controller;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import com.cs.cakeshop.enums.ProductType;
import com.cs.cakeshop.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    // Create new product
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> createProduct(
            @RequestPart("product") String productJson,
            @RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestPart(value = "subImage1", required = false) MultipartFile subImage1,
            @RequestPart(value = "subImage2", required = false) MultipartFile subImage2,
            @RequestPart(value = "subImage3", required = false) MultipartFile subImage3,
            @RequestPart(value = "subImage4", required = false) MultipartFile subImage4) {

        try {
            ProductRequestDto productDto = objectMapper.readValue(productJson, ProductRequestDto.class);
            ProductResponseDto createdProduct = productService.createProduct(
                    productDto, mainImage, subImage1, subImage2, subImage3, subImage4);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } catch (Exception e) {
            throw new RuntimeException("Error creating product: " + e.getMessage(), e);
        }
    }

    // Get all products
    @GetMapping("/get-All-Products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        ProductResponseDto product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // Update product
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long id,
            @RequestPart("product") String productJson,
            @RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestPart(value = "subImage1", required = false) MultipartFile subImage1,
            @RequestPart(value = "subImage2", required = false) MultipartFile subImage2,
            @RequestPart(value = "subImage3", required = false) MultipartFile subImage3,
            @RequestPart(value = "subImage4", required = false) MultipartFile subImage4) {

        try {
            ProductRequestDto productDto = objectMapper.readValue(productJson, ProductRequestDto.class);
            ProductResponseDto updatedProduct = productService.updateProduct(
                    id, productDto, mainImage, subImage1, subImage2, subImage3, subImage4);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            throw new RuntimeException("Error updating product: " + e.getMessage(), e);
        }
    }

    // Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Get products by type
    @GetMapping("/type/{productType}")
    public ResponseEntity<List<ProductResponseDto>> getProductsByType(@PathVariable ProductType productType) {
        List<ProductResponseDto> products = productService.getProductsByType(productType);
        return ResponseEntity.ok(products);
    }

    // Get products by categories
    @GetMapping("/categories")
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategories(@RequestParam Set<Long> categoryIds) {
        List<ProductResponseDto> products = productService.getProductsByCategory(categoryIds);
        return ResponseEntity.ok(products);
    }

    // Get featured products
    @GetMapping("/featured")
    public ResponseEntity<List<ProductResponseDto>> getFeaturedProducts() {
        List<ProductResponseDto> products = productService.getFeaturedProducts();
        return ResponseEntity.ok(products);
    }

    // Get product image
    @GetMapping("/{id}/image/{imageType}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Long id, @PathVariable String imageType) {
        byte[] imageData = productService.getProductImage(id, imageType);
        if (imageData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageData);
    }
}
