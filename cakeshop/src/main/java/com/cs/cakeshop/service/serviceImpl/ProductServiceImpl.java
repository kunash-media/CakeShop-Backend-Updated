package com.cs.cakeshop.service.serviceImpl;

import com.cs.cakeshop.Dto.request.ProductRequestDto;
import com.cs.cakeshop.Dto.response.CategoryResponseDto;
import com.cs.cakeshop.Dto.response.ProductResponseDto;
import com.cs.cakeshop.entity.Category;
import com.cs.cakeshop.entity.Product;
import com.cs.cakeshop.enums.ProductType;
import com.cs.cakeshop.repository.CategoryRepository;
import com.cs.cakeshop.repository.ProductRepository;
import com.cs.cakeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productDto,
                                            MultipartFile mainImage,
                                            MultipartFile subImage1,
                                            MultipartFile subImage2,
                                            MultipartFile subImage3,
                                            MultipartFile subImage4) {

        Product product = new Product();
        mapDtoToEntity(productDto, product);

        // Handle images
        try {
            if (mainImage != null && !mainImage.isEmpty()) {
                product.setMainImage(mainImage.getBytes());
            }
            if (subImage1 != null && !subImage1.isEmpty()) {
                product.setSubImage1(subImage1.getBytes());
            }
            if (subImage2 != null && !subImage2.isEmpty()) {
                product.setSubImage2(subImage2.getBytes());
            }
            if (subImage3 != null && !subImage3.isEmpty()) {
                product.setSubImage3(subImage3.getBytes());
            }
            if (subImage4 != null && !subImage4.isEmpty()) {
                product.setSubImage4(subImage4.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing image files", e);
        }

        // Handle categories
        if (productDto.getCategoryIds() != null && !productDto.getCategoryIds().isEmpty()) {
            Set<Category> categories = new HashSet<>(categoryRepository.findAllById(productDto.getCategoryIds()));
            product.setCategories(categories);
        }

        Product savedProduct = productRepository.save(product);
        return mapEntityToDto(savedProduct);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return mapEntityToDto(product);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productDto,
                                            MultipartFile mainImage,
                                            MultipartFile subImage1,
                                            MultipartFile subImage2,
                                            MultipartFile subImage3,
                                            MultipartFile subImage4) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        mapDtoToEntity(productDto, product);

        // Handle images
        try {
            if (mainImage != null && !mainImage.isEmpty()) {
                product.setMainImage(mainImage.getBytes());
            }
            if (subImage1 != null && !subImage1.isEmpty()) {
                product.setSubImage1(subImage1.getBytes());
            }
            if (subImage2 != null && !subImage2.isEmpty()) {
                product.setSubImage2(subImage2.getBytes());
            }
            if (subImage3 != null && !subImage3.isEmpty()) {
                product.setSubImage3(subImage3.getBytes());
            }
            if (subImage4 != null && !subImage4.isEmpty()) {
                product.setSubImage4(subImage4.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing image files", e);
        }

        // Handle categories
        if (productDto.getCategoryIds() != null && !productDto.getCategoryIds().isEmpty()) {
            Set<Category> categories = new HashSet<>(categoryRepository.findAllById(productDto.getCategoryIds()));
            product.setCategories(categories);
        }

        Product savedProduct = productRepository.save(product);
        return mapEntityToDto(savedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        productRepository.delete(product);
    }

    @Override
    public List<ProductResponseDto> getProductsByType(ProductType productType) {
        List<Product> products = productRepository.findByProductType(productType);
        return products.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> getProductsByCategory(Set<Long> categoryIds) {
        List<Product> products = productRepository.findByCategoryIds(categoryIds);
        return products.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> getFeaturedProducts() {
        List<Product> products = productRepository.findByIsFeatured(true);
        return products.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public byte[] getProductImage(Long productId, String imageType) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        switch (imageType.toLowerCase()) {
            case "main":
                return product.getMainImage();
            case "sub1":
                return product.getSubImage1();
            case "sub2":
                return product.getSubImage2();
            case "sub3":
                return product.getSubImage3();
            case "sub4":
                return product.getSubImage4();
            default:
                throw new RuntimeException("Invalid image type: " + imageType);
        }
    }

    private void mapDtoToEntity(ProductRequestDto dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setProductType(dto.getProductType());
        entity.setRatings(dto.getRatings());
        entity.setReview(dto.getReview());
        entity.setOldPrice(dto.getOldPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setOffers(dto.getOffers());
        entity.setKeyHighlights(dto.getKeyHighlights());
        entity.setWeight(dto.getWeight());
        entity.setQuantity(dto.getQuantity());
        entity.setProductDetails(dto.getProductDetails());
        entity.setCakeDetails(dto.getCakeDetails());
        entity.setStorageCare(dto.getStorageCare());
        entity.setIngredients(dto.getIngredients());
        entity.setIsAvailable(dto.getIsAvailable());
        entity.setIsFeatured(dto.getIsFeatured());
    }

    private ProductResponseDto mapEntityToDto(Product entity) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setProductType(entity.getProductType());
        dto.setRatings(entity.getRatings());
        dto.setReview(entity.getReview());
        dto.setOldPrice(entity.getOldPrice());
        dto.setDiscount(entity.getDiscount());
        dto.setOffers(entity.getOffers());
        dto.setKeyHighlights(entity.getKeyHighlights());
        dto.setWeight(entity.getWeight());
        dto.setQuantity(entity.getQuantity());
        dto.setProductDetails(entity.getProductDetails());
        dto.setCakeDetails(entity.getCakeDetails());
        dto.setStorageCare(entity.getStorageCare());
        dto.setIngredients(entity.getIngredients());
        dto.setIsAvailable(entity.getIsAvailable());
        dto.setIsFeatured(entity.getIsFeatured());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        // Convert images to Base64
        if (entity.getMainImage() != null) {
            dto.setMainImageBase64(Base64.getEncoder().encodeToString(entity.getMainImage()));
        }
        if (entity.getSubImage1() != null) {
            dto.setSubImage1Base64(Base64.getEncoder().encodeToString(entity.getSubImage1()));
        }
        if (entity.getSubImage2() != null) {
            dto.setSubImage2Base64(Base64.getEncoder().encodeToString(entity.getSubImage2()));
        }
        if (entity.getSubImage3() != null) {
            dto.setSubImage3Base64(Base64.getEncoder().encodeToString(entity.getSubImage3()));
        }
        if (entity.getSubImage4() != null) {
            dto.setSubImage4Base64(Base64.getEncoder().encodeToString(entity.getSubImage4()));
        }

        // Map categories
        if (entity.getCategories() != null) {
            Set<CategoryResponseDto> categoryDtos = entity.getCategories().stream()
                    .map(this::mapCategoryToDto)
                    .collect(Collectors.toSet());
            dto.setCategories(categoryDtos);
        }

        return dto;
    }

    private CategoryResponseDto mapCategoryToDto(Category entity) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setDescription(entity.getDescription());
        dto.setIcon(entity.getIcon());
        return dto;
    }
}
