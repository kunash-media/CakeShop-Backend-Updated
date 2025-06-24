package com.cs.cakeshop.service;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto,
                                     MultipartFile basicImage,
                                     MultipartFile withOrchidsImage,
                                     MultipartFile productImage,
                                     List<MultipartFile> productSubImages);

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto,
                                     MultipartFile basicImage,
                                     MultipartFile withOrchidsImage,
                                     MultipartFile productImage,
                                     List<MultipartFile> productSubImages);

    void deleteProduct(Long id);
}