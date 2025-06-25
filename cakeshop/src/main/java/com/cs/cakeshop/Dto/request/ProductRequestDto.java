package com.cs.cakeshop.Dto.request;

import com.cs.cakeshop.enums.ProductType;

import java.util.List;

public class ProductRequestDto {

    private ProductType type;
    private String productName;
    private Double ratings;
    private Integer reviews;
    private Double productOldPrice;
    private Double productNewPrice;
    private List<String> weights;
    private List<Double> weightPrices;
    private String nameOnCake;
    private String offers;
    private String productContains;
    private String description;
    private String careInstructions;
    private String skuNumber;
    private String note;

    // Constructors
    public ProductRequestDto() {}

    // Getters and Setters
    public ProductType getType() { return type; }
    public void setType(ProductType type) { this.type = type; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Double getRatings() { return ratings; }
    public void setRatings(Double ratings) { this.ratings = ratings; }

    public Integer getReviews() { return reviews; }
    public void setReviews(Integer reviews) { this.reviews = reviews; }

    public Double getProductOldPrice() { return productOldPrice; }
    public void setProductOldPrice(Double productOldPrice) { this.productOldPrice = productOldPrice; }

    public Double getProductNewPrice() { return productNewPrice; }
    public void setProductNewPrice(Double productNewPrice) { this.productNewPrice = productNewPrice; }

    public List<String> getWeights() { return weights; }
    public void setWeights(List<String> weights) { this.weights = weights; }

    public List<Double> getWeightPrices() { return weightPrices; }
    public void setWeightPrices(List<Double> weightPrices) { this.weightPrices = weightPrices; }

    public String getNameOnCake() { return nameOnCake; }
    public void setNameOnCake(String nameOnCake) { this.nameOnCake = nameOnCake; }

    public String getOffers() { return offers; }
    public void setOffers(String offers) { this.offers = offers; }

    public String getProductContains() { return productContains; }
    public void setProductContains(String productContains) { this.productContains = productContains; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCareInstructions() { return careInstructions; }
    public void setCareInstructions(String careInstructions) { this.careInstructions = careInstructions; }

    public String getSkuNumber() { return skuNumber; }
    public void setSkuNumber(String skuNumber) { this.skuNumber = skuNumber; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
