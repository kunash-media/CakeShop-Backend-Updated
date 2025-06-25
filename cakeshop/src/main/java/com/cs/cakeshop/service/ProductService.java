package com.cs.cakeshop.service;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import com.cs.cakeshop.enums.ProductType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productDto,
                                     MultipartFile mainImage,
                                     MultipartFile subImage1,
                                     MultipartFile subImage2,
                                     MultipartFile subImage3,
                                     MultipartFile subImage4);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(Long id);

    ProductResponseDto updateProduct(Long id, ProductRequestDto productDto,
                                     MultipartFile mainImage,
                                     MultipartFile subImage1,
                                     MultipartFile subImage2,
                                     MultipartFile subImage3,
                                     MultipartFile subImage4);

    void deleteProduct(Long id);

    List<ProductResponseDto> getProductsByType(ProductType productType);

    List<ProductResponseDto> getProductsByCategory(Set<Long> categoryIds);

    List<ProductResponseDto> getFeaturedProducts();

    byte[] getProductImage(Long productId, String imageType);
}
