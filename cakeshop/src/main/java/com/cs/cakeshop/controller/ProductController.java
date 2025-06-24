package com.cs.cakeshop.controller;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import com.cs.cakeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<ProductResponseDto> createProduct(
            @RequestPart("productData") ProductRequestDto productRequestDto,
            @RequestPart(value = "basicImage", required = false) MultipartFile basicImage,
            @RequestPart(value = "withOrchidsImage", required = false) MultipartFile withOrchidsImage,
            @RequestPart(value = "productImage", required = false) MultipartFile productImage,
            @RequestPart(value = "productSubImages", required = false) List<MultipartFile> productSubImages) {

        try {
            ProductResponseDto createdProduct = productService.createProduct(
                    productRequestDto, basicImage, withOrchidsImage, productImage, productSubImages);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        try {
            ProductResponseDto product = productService.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        try {
            List<ProductResponseDto> products = productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long id,
            @RequestPart("productData") ProductRequestDto productRequestDto,
            @RequestPart(value = "basicImage", required = false) MultipartFile basicImage,
            @RequestPart(value = "withOrchidsImage", required = false) MultipartFile withOrchidsImage,
            @RequestPart(value = "productImage", required = false) MultipartFile productImage,
            @RequestPart(value = "productSubImages", required = false) List<MultipartFile> productSubImages) {

        try {
            ProductResponseDto updatedProduct = productService.updateProduct(
                    id, productRequestDto, basicImage, withOrchidsImage, productImage, productSubImages);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
