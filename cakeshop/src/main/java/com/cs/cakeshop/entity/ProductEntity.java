package com.cs.cakeshop.entity;

import com.cs.cakeshop.enums.ProductType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    private String productName;
    private Double ratings;
    private Integer reviews;
    private Double productOldPrice;
    private Double productNewPrice;

    @ElementCollection
    @CollectionTable(name = "product_weights", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "weight")
    private List<String> weights;

    @ElementCollection
    @CollectionTable(name = "product_weight_prices", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "price")
    private List<Double> weightPrices;

    private String nameOnCake;
    private String offers;
    private String productContains;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String careInstructions;
    private String skuNumber;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] productImage;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] subImage1;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] subImage2;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] subImage3;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] video;

    // Constructors
    public ProductEntity() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public byte[] getProductImage() { return productImage; }
    public void setProductImage(byte[] productImage) { this.productImage = productImage; }

    public byte[] getSubImage1() { return subImage1; }
    public void setSubImage1(byte[] subImage1) { this.subImage1 = subImage1; }

    public byte[] getSubImage2() { return subImage2; }
    public void setSubImage2(byte[] subImage2) { this.subImage2 = subImage2; }

    public byte[] getSubImage3() { return subImage3; }
    public void setSubImage3(byte[] subImage3) { this.subImage3 = subImage3; }

    public byte[] getVideo() { return video; }
    public void setVideo(byte[] video) { this.video = video; }
}
