package com.cs.cakeshop.Dto.response;

import com.cs.cakeshop.enums.CategoryType;

public class CategoryResponseDto {
    private Long id;
    private String name;
    private CategoryType type;
    private String description;
    private String icon;

    // Constructors
    public CategoryResponseDto() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CategoryType getType() { return type; }
    public void setType(CategoryType type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
}

