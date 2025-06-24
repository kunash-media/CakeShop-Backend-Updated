package com.cs.cakeshop.service.serviceImpl;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import com.cs.cakeshop.entity.ProductEntity;
import com.cs.cakeshop.repository.ProductRepository;
import com.cs.cakeshop.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto,
                                            MultipartFile basicImage,
                                            MultipartFile withOrchidsImage,
                                            MultipartFile productImage,
                                            List<MultipartFile> productSubImages) {

        ProductEntity productEntity = convertRequestDtoToEntity(productRequestDto);

        try {
            // Handle images
            if (basicImage != null && !basicImage.isEmpty()) {
                productEntity.setBasicImage(basicImage.getBytes());
            }
            if (withOrchidsImage != null && !withOrchidsImage.isEmpty()) {
                productEntity.setWithOrchidsImage(withOrchidsImage.getBytes());
            }
            if (productImage != null && !productImage.isEmpty()) {
                productEntity.setProductImage(productImage.getBytes());
            }
            if (productSubImages != null && !productSubImages.isEmpty()) {
                byte[] subImagesBytes = convertMultipleFilesToBytes(productSubImages);
                productEntity.setProductSubImages(subImagesBytes);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error processing images: " + e.getMessage());
        }

        ProductEntity savedEntity = productRepository.save(productEntity);
        return convertEntityToResponseDto(savedEntity);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            return convertEntityToResponseDto(productEntity.get());
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        List<ProductResponseDto> responseDtos = new ArrayList<>();

        for (ProductEntity product : products) {
            responseDtos.add(convertEntityToResponseDto(product));
        }

        return responseDtos;
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto,
                                            MultipartFile basicImage,
                                            MultipartFile withOrchidsImage,
                                            MultipartFile productImage,
                                            List<MultipartFile> productSubImages) {

        Optional<ProductEntity> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        ProductEntity productEntity = existingProduct.get();
        updateEntityFromRequestDto(productEntity, productRequestDto);

        try {
            // Update images if provided
            if (basicImage != null && !basicImage.isEmpty()) {
                productEntity.setBasicImage(basicImage.getBytes());
            }
            if (withOrchidsImage != null && !withOrchidsImage.isEmpty()) {
                productEntity.setWithOrchidsImage(withOrchidsImage.getBytes());
            }
            if (productImage != null && !productImage.isEmpty()) {
                productEntity.setProductImage(productImage.getBytes());
            }
            if (productSubImages != null && !productSubImages.isEmpty()) {
                byte[] subImagesBytes = convertMultipleFilesToBytes(productSubImages);
                productEntity.setProductSubImages(subImagesBytes);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error processing images: " + e.getMessage());
        }

        ProductEntity savedEntity = productRepository.save(productEntity);
        return convertEntityToResponseDto(savedEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    private ProductEntity convertRequestDtoToEntity(ProductRequestDto dto) {
        ProductEntity entity = new ProductEntity();
        updateEntityFromRequestDto(entity, dto);
        return entity;
    }

    private void updateEntityFromRequestDto(ProductEntity entity, ProductRequestDto dto) {
        entity.setType(dto.getType());
        entity.setProductName(dto.getProductName());
        entity.setRatings(dto.getRatings());
        entity.setReviews(dto.getReviews());
        entity.setProductOldPrice(dto.getProductOldPrice());
        entity.setProductNewPrice(dto.getProductNewPrice());
        entity.setProductDiscount(dto.getProductDiscount());
        entity.setBasicTitle(dto.getBasicTitle());
        entity.setBasicPrice(dto.getBasicPrice());
        entity.setWithOrchidsTitle(dto.getWithOrchidsTitle());
        entity.setWithOrchidsPrice(dto.getWithOrchidsPrice());
        entity.setNameOnCake(dto.getNameOnCake());
        entity.setAddress(dto.getAddress());
        entity.setDescription(dto.getDescription());
        entity.setSkuNumber(dto.getSkuNumber());
        entity.setNote(dto.getNote());

        try {
            if (dto.getWeight() != null) {
                entity.setWeight(objectMapper.writeValueAsString(dto.getWeight()));
            }
            if (dto.getOffers() != null) {
                entity.setOffers(objectMapper.writeValueAsString(dto.getOffers()));
            }
            if (dto.getProductContains() != null) {
                entity.setProductContains(objectMapper.writeValueAsString(dto.getProductContains()));
            }
            if (dto.getCareInstructions() != null) {
                entity.setCareInstructions(objectMapper.writeValueAsString(dto.getCareInstructions()));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting lists to JSON: " + e.getMessage());
        }
    }

    private ProductResponseDto convertEntityToResponseDto(ProductEntity entity) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setProductName(entity.getProductName());
        dto.setRatings(entity.getRatings());
        dto.setReviews(entity.getReviews());
        dto.setProductOldPrice(entity.getProductOldPrice());
        dto.setProductNewPrice(entity.getProductNewPrice());
        dto.setProductDiscount(entity.getProductDiscount());
        dto.setNameOnCake(entity.getNameOnCake());
        dto.setAddress(entity.getAddress());
        dto.setDescription(entity.getDescription());
        dto.setSkuNumber(entity.getSkuNumber());
        dto.setNote(entity.getNote());

        // Convert orchids data
        ProductResponseDto.OrchidsDto orchids = new ProductResponseDto.OrchidsDto();
        ProductResponseDto.BasicDto basic = new ProductResponseDto.BasicDto();
        basic.setTitle(entity.getBasicTitle());
        basic.setPrice(entity.getBasicPrice());
        if (entity.getBasicImage() != null) {
            basic.setImage("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(entity.getBasicImage()));
        }

        ProductResponseDto.WithOrchidsDto withOrchidsDto = new ProductResponseDto.WithOrchidsDto();
        withOrchidsDto.setTitle(entity.getWithOrchidsTitle());
        withOrchidsDto.setPrice(entity.getWithOrchidsPrice());
        if (entity.getWithOrchidsImage() != null) {
            withOrchidsDto.setImage("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(entity.getWithOrchidsImage()));
        }

        orchids.setBasic(basic);
        orchids.setWithOrchids(withOrchidsDto);
        dto.setOrchids(orchids);

        // Convert main product image
        if (entity.getProductImage() != null) {
            dto.setProductImage("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(entity.getProductImage()));
        }

        try {
            // Convert JSON strings back to lists
            if (entity.getWeight() != null) {
                dto.setWeight(objectMapper.readValue(entity.getWeight(), List.class));
            }
            if (entity.getOffers() != null) {
                dto.setOffers(objectMapper.readValue(entity.getOffers(), List.class));
            }
            if (entity.getProductContains() != null) {
                dto.setProductContains(objectMapper.readValue(entity.getProductContains(), List.class));
            }
            if (entity.getCareInstructions() != null) {
                dto.setCareInstructions(objectMapper.readValue(entity.getCareInstructions(), List.class));
            }
            if (entity.getProductSubImages() != null) {
                List<String> subImages = convertBytesToBase64List(entity.getProductSubImages());
                dto.setProductSubImages(subImages);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to lists: " + e.getMessage());
        }

        return dto;
    }

    private byte[] convertMultipleFilesToBytes(List<MultipartFile> files) throws IOException {
        List<byte[]> fileBytesList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                fileBytesList.add(file.getBytes());
            }
        }

        try {
            return objectMapper.writeValueAsBytes(fileBytesList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing multiple files: " + e.getMessage());
        }
    }

    private List<String> convertBytesToBase64List(byte[] bytes) {
        try {
            List<byte[]> fileBytesList = objectMapper.readValue(bytes, List.class);
            List<String> base64List = new ArrayList<>();
            for (Object fileBytes : fileBytesList) {
                if (fileBytes instanceof List) {
                    List<Integer> byteList = (List<Integer>) fileBytes;
                    byte[] byteArray = new byte[byteList.size()];
                    for (int i = 0; i < byteList.size(); i++) {
                        byteArray[i] = byteList.get(i).byteValue();
                    }
                    base64List.add("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(byteArray));
                }
            }
            return base64List;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing multiple files: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
