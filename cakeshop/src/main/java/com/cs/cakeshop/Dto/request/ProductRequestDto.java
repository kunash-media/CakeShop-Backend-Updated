package com.cs.cakeshop.Dto.request;

import com.cs.cakeshop.enums.ProductType;

import java.math.BigDecimal;
import java.util.Set;

public class ProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
    private ProductType productType;
    private Double ratings;
    private String review;
    private BigDecimal oldPrice;
    private Integer discount;
    private String offers;
    private String keyHighlights;
    private String weight;
    private Integer quantity;
    private String productDetails;
    private String cakeDetails;
    private String storageCare;
    private String ingredients;
    private Set<Long> categoryIds;
    private Boolean isAvailable;
    private Boolean isFeatured;

    // Constructors
    public ProductRequestDto() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public ProductType getProductType() { return productType; }
    public void setProductType(ProductType productType) { this.productType = productType; }

    public Double getRatings() { return ratings; }
    public void setRatings(Double ratings) { this.ratings = ratings; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public BigDecimal getOldPrice() { return oldPrice; }
    public void setOldPrice(BigDecimal oldPrice) { this.oldPrice = oldPrice; }

    public Integer getDiscount() { return discount; }
    public void setDiscount(Integer discount) { this.discount = discount; }

    public String getOffers() { return offers; }
    public void setOffers(String offers) { this.offers = offers; }

    public String getKeyHighlights() { return keyHighlights; }
    public void setKeyHighlights(String keyHighlights) { this.keyHighlights = keyHighlights; }

    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getProductDetails() { return productDetails; }
    public void setProductDetails(String productDetails) { this.productDetails = productDetails; }

    public String getCakeDetails() { return cakeDetails; }
    public void setCakeDetails(String cakeDetails) { this.cakeDetails = cakeDetails; }

    public String getStorageCare() { return storageCare; }
    public void setStorageCare(String storageCare) { this.storageCare = storageCare; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public Set<Long> getCategoryIds() { return categoryIds; }
    public void setCategoryIds(Set<Long> categoryIds) { this.categoryIds = categoryIds; }

    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }

    public Boolean getIsFeatured() { return isFeatured; }
    public void setIsFeatured(Boolean isFeatured) { this.isFeatured = isFeatured; }
}
