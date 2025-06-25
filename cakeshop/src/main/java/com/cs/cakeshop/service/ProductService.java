package com.cs.cakeshop.service;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import com.cs.cakeshop.enums.ProductType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto requestDto,
                                     MultipartFile productImage,
                                     MultipartFile subImage1,
                                     MultipartFile subImage2,
                                     MultipartFile subImage3,
                                     MultipartFile video);

    ProductResponseDto getProductById(Long id);
    List<ProductResponseDto> getAllProducts();
    List<ProductResponseDto> getProductsByType(ProductType type);

    ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto,
                                     MultipartFile productImage,
                                     MultipartFile subImage1,
                                     MultipartFile subImage2,
                                     MultipartFile subImage3,
                                     MultipartFile video);

    void deleteProduct(Long id);
    byte[] getProductImage(Long id);
    byte[] getSubImage1(Long id);
    byte[] getSubImage2(Long id);
    byte[] getSubImage3(Long id);
    byte[] getVideo(Long id);
}
