package com.cs.cakeshop.controller;

import com.cs.cakeshop.Dto.response.CategoryResponseDto;
import com.cs.cakeshop.entity.Category;
import com.cs.cakeshop.enums.CategoryType;
import com.cs.cakeshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/get-All-Categories")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(
            @RequestParam(required = false) CategoryType type) {

        List<Category> categories;
        if (type != null) {
            categories = categoryRepository.findByType(type);
        } else {
            categories = categoryRepository.findAll();
        }

        List<CategoryResponseDto> categoryDtos = categories.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(categoryDtos);
    }

    @PostMapping("/create-Category")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryResponseDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setType(categoryDto.getType());
        category.setDescription(categoryDto.getDescription());
        category.setIcon(categoryDto.getIcon());

        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDto(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return ResponseEntity.ok(mapToDto(category));
    }

    private CategoryResponseDto mapToDto(Category entity) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setDescription(entity.getDescription());
        dto.setIcon(entity.getIcon());
        return dto;
    }
}

