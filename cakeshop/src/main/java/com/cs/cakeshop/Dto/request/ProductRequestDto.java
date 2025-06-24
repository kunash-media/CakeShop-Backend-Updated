package com.cs.cakeshop.Dto.request;

import java.util.List;

public class ProductRequestDto {

    private String type;
    private String productName;
    private Double ratings;
    private Integer reviews;
    private Double productOldPrice;
    private Double productNewPrice;
    private String productDiscount;
    private String basicTitle;
    private Double basicPrice;
    private String withOrchidsTitle;
    private Double withOrchidsPrice;
    private List<Double> weight;
    private String nameOnCake;
    private String address;
    private List<String> offers;
    private List<String> productContains;
    private String description;
    private List<String> careInstructions;
    private String skuNumber;
    private String note;

    // Default constructor
    public ProductRequestDto() {}

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Double getProductOldPrice() {
        return productOldPrice;
    }

    public void setProductOldPrice(Double productOldPrice) {
        this.productOldPrice = productOldPrice;
    }

    public Double getProductNewPrice() {
        return productNewPrice;
    }

    public void setProductNewPrice(Double productNewPrice) {
        this.productNewPrice = productNewPrice;
    }

    public String getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getBasicTitle() {
        return basicTitle;
    }

    public void setBasicTitle(String basicTitle) {
        this.basicTitle = basicTitle;
    }

    public Double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public String getWithOrchidsTitle() {
        return withOrchidsTitle;
    }

    public void setWithOrchidsTitle(String withOrchidsTitle) {
        this.withOrchidsTitle = withOrchidsTitle;
    }

    public Double getWithOrchidsPrice() {
        return withOrchidsPrice;
    }

    public void setWithOrchidsPrice(Double withOrchidsPrice) {
        this.withOrchidsPrice = withOrchidsPrice;
    }

    public List<Double> getWeight() {
        return weight;
    }

    public void setWeight(List<Double> weight) {
        this.weight = weight;
    }

    public String getNameOnCake() {
        return nameOnCake;
    }

    public void setNameOnCake(String nameOnCake) {
        this.nameOnCake = nameOnCake;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getOffers() {
        return offers;
    }

    public void setOffers(List<String> offers) {
        this.offers = offers;
    }

    public List<String> getProductContains() {
        return productContains;
    }

    public void setProductContains(List<String> productContains) {
        this.productContains = productContains;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCareInstructions() {
        return careInstructions;
    }

    public void setCareInstructions(List<String> careInstructions) {
        this.careInstructions = careInstructions;
    }

    public String getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(String skuNumber) {
        this.skuNumber = skuNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
