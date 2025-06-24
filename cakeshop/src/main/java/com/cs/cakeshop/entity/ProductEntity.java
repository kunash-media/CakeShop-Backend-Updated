package com.cs.cakeshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "ratings")
    private Double ratings;

    @Column(name = "reviews")
    private Integer reviews;

    @Column(name = "product_old_price")
    private Double productOldPrice;

    @Column(name = "product_new_price")
    private Double productNewPrice;

    @Column(name = "product_discount")
    private String productDiscount;

    @Column(name = "basic_image", columnDefinition = "LONGBLOB")
    private byte[] basicImage;

    @Column(name = "basic_title")
    private String basicTitle;

    @Column(name = "basic_price")
    private Double basicPrice;

    @Column(name = "with_orchids_image", columnDefinition = "LONGBLOB")
    private byte[] withOrchidsImage;

    @Column(name = "with_orchids_title")
    private String withOrchidsTitle;

    @Column(name = "with_orchids_price")
    private Double withOrchidsPrice;

    @Column(name = "weight")
    private String weight; // JSON string for array

    @Column(name = "name_on_cake")
    private String nameOnCake;

    @Column(name = "address")
    private String address;

    @Column(name = "offers", columnDefinition = "TEXT")
    private String offers; // JSON string for array

    @Column(name = "product_contains", columnDefinition = "TEXT")
    private String productContains; // JSON string for array

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "care_instructions", columnDefinition = "TEXT")
    private String careInstructions; // JSON string for array

    @Column(name = "sku_number")
    private String skuNumber;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "product_image", columnDefinition = "LONGBLOB")
    private byte[] productImage;

    @Column(name = "product_sub_images", columnDefinition = "LONGBLOB")
    private byte[] productSubImages; // Store as serialized byte array

    // Default constructor
    public ProductEntity() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public byte[] getBasicImage() {
        return basicImage;
    }

    public void setBasicImage(byte[] basicImage) {
        this.basicImage = basicImage;
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

    public byte[] getWithOrchidsImage() {
        return withOrchidsImage;
    }

    public void setWithOrchidsImage(byte[] withOrchidsImage) {
        this.withOrchidsImage = withOrchidsImage;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public String getProductContains() {
        return productContains;
    }

    public void setProductContains(String productContains) {
        this.productContains = productContains;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCareInstructions() {
        return careInstructions;
    }

    public void setCareInstructions(String careInstructions) {
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

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public byte[] getProductSubImages() {
        return productSubImages;
    }

    public void setProductSubImages(byte[] productSubImages) {
        this.productSubImages = productSubImages;
    }
}