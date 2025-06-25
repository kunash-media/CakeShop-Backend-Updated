package com.cs.cakeshop.service.serviceImpl;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import com.cs.cakeshop.entity.ProductEntity;
import com.cs.cakeshop.enums.ProductType;
import com.cs.cakeshop.repository.ProductRepository;
import com.cs.cakeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto requestDto,
                                            MultipartFile productImage,
                                            MultipartFile subImage1,
                                            MultipartFile subImage2,
                                            MultipartFile subImage3,
                                            MultipartFile video) {
        ProductEntity entity = new ProductEntity();
        mapDtoToEntity(requestDto, entity);

        try {
            if (productImage != null && !productImage.isEmpty()) {
                entity.setProductImage(productImage.getBytes());
            }
            if (subImage1 != null && !subImage1.isEmpty()) {
                entity.setSubImage1(subImage1.getBytes());
            }
            if (subImage2 != null && !subImage2.isEmpty()) {
                entity.setSubImage2(subImage2.getBytes());
            }
            if (subImage3 != null && !subImage3.isEmpty()) {
                entity.setSubImage3(subImage3.getBytes());
            }
            if (video != null && !video.isEmpty()) {
                entity.setVideo(video.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing files", e);
        }

        ProductEntity savedEntity = productRepository.save(entity);
        return mapEntityToDto(savedEntity);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapEntityToDto(entity);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> getProductsByType(ProductType type) {
        return productRepository.findByType(type).stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto,
                                            MultipartFile productImage,
                                            MultipartFile subImage1,
                                            MultipartFile subImage2,
                                            MultipartFile subImage3,
                                            MultipartFile video) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        mapDtoToEntity(requestDto, entity);

        try {
            if (productImage != null && !productImage.isEmpty()) {
                entity.setProductImage(productImage.getBytes());
            }
            if (subImage1 != null && !subImage1.isEmpty()) {
                entity.setSubImage1(subImage1.getBytes());
            }
            if (subImage2 != null && !subImage2.isEmpty()) {
                entity.setSubImage2(subImage2.getBytes());
            }
            if (subImage3 != null && !subImage3.isEmpty()) {
                entity.setSubImage3(subImage3.getBytes());
            }
            if (video != null && !video.isEmpty()) {
                entity.setVideo(video.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing files", e);
        }

        ProductEntity updatedEntity = productRepository.save(entity);
        return mapEntityToDto(updatedEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public byte[] getProductImage(Long id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return entity.getProductImage();
    }

    @Override
    public byte[] getSubImage1(Long id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return entity.getSubImage1();
    }

    @Override
    public byte[] getSubImage2(Long id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return entity.getSubImage2();
    }

    @Override
    public byte[] getSubImage3(Long id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return entity.getSubImage3();
    }

    @Override
    public byte[] getVideo(Long id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return entity.getVideo();
    }

    private void mapDtoToEntity(ProductRequestDto dto, ProductEntity entity) {
        entity.setType(dto.getType());
        entity.setProductName(dto.getProductName());
        entity.setRatings(dto.getRatings());
        entity.setReviews(dto.getReviews());
        entity.setProductOldPrice(dto.getProductOldPrice());
        entity.setProductNewPrice(dto.getProductNewPrice());
        entity.setWeights(dto.getWeights());
        entity.setWeightPrices(dto.getWeightPrices());
        entity.setNameOnCake(dto.getNameOnCake());
        entity.setOffers(dto.getOffers());
        entity.setProductContains(dto.getProductContains());
        entity.setDescription(dto.getDescription());
        entity.setCareInstructions(dto.getCareInstructions());
        entity.setSkuNumber(dto.getSkuNumber());
        entity.setNote(dto.getNote());
    }

    private ProductResponseDto mapEntityToDto(ProductEntity entity) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setProductName(entity.getProductName());
        dto.setRatings(entity.getRatings());
        dto.setReviews(entity.getReviews());
        dto.setProductOldPrice(entity.getProductOldPrice());
        dto.setProductNewPrice(entity.getProductNewPrice());
        dto.setWeights(entity.getWeights());
        dto.setWeightPrices(entity.getWeightPrices());
        dto.setNameOnCake(entity.getNameOnCake());
        dto.setOffers(entity.getOffers());
        dto.setProductContains(entity.getProductContains());
        dto.setDescription(entity.getDescription());
        dto.setCareInstructions(entity.getCareInstructions());
        dto.setSkuNumber(entity.getSkuNumber());
        dto.setNote(entity.getNote());
        dto.setHasProductImage(entity.getProductImage() != null);
        dto.setHasSubImage1(entity.getSubImage1() != null);
        dto.setHasSubImage2(entity.getSubImage2() != null);
        dto.setHasSubImage3(entity.getSubImage3() != null);
        dto.setHasVideo(entity.getVideo() != null);
        return dto;
    }
}
