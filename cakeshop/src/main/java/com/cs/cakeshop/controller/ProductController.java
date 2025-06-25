package com.cs.cakeshop.controller;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import com.cs.cakeshop.enums.ProductType;
import com.cs.cakeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> createProduct(
            @RequestPart("product") ProductRequestDto requestDto,
            @RequestPart(value = "productImage", required = false) MultipartFile productImage,
            @RequestPart(value = "subImage1", required = false) MultipartFile subImage1,
            @RequestPart(value = "subImage2", required = false) MultipartFile subImage2,
            @RequestPart(value = "subImage3", required = false) MultipartFile subImage3,
            @RequestPart(value = "video", required = false) MultipartFile video) {

        ProductResponseDto response = productService.createProduct(requestDto, productImage,
                subImage1, subImage2, subImage3, video);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        ProductResponseDto response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> response = productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<ProductResponseDto>> getProductsByType(@PathVariable ProductType type) {
        List<ProductResponseDto> response = productService.getProductsByType(type);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long id,
            @RequestPart("product") ProductRequestDto requestDto,
            @RequestPart(value = "productImage", required = false) MultipartFile productImage,
            @RequestPart(value = "subImage1", required = false) MultipartFile subImage1,
            @RequestPart(value = "subImage2", required = false) MultipartFile subImage2,
            @RequestPart(value = "subImage3", required = false) MultipartFile subImage3,
            @RequestPart(value = "video", required = false) MultipartFile video) {

        ProductResponseDto response = productService.updateProduct(id, requestDto, productImage,
                subImage1, subImage2, subImage3, video);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/image/main")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Long id) {
        byte[] image = productService.getProductImage(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(image);
    }

    @GetMapping("/{id}/image/sub1")
    public ResponseEntity<byte[]> getSubImage1(@PathVariable Long id) {
        byte[] image = productService.getSubImage1(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(image);
    }

    @GetMapping("/{id}/image/sub2")
    public ResponseEntity<byte[]> getSubImage2(@PathVariable Long id) {
        byte[] image = productService.getSubImage2(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(image);
    }

    @GetMapping("/{id}/image/sub3")
    public ResponseEntity<byte[]> getSubImage3(@PathVariable Long id) {
        byte[] image = productService.getSubImage3(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(image);
    }

    @GetMapping("/{id}/video")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) {
        byte[] video = productService.getVideo(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .body(video);
    }
}