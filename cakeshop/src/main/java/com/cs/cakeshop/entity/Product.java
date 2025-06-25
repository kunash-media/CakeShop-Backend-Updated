package com.cs.cakeshop.entity;

import com.cs.cakeshop.enums.ProductType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Lob
    @Column(name = "main_image", columnDefinition = "LONGBLOB")
    private byte[] mainImage;

    @Lob
    @Column(name = "sub_image1", columnDefinition = "LONGBLOB")
    private byte[] subImage1;

    @Lob
    @Column(name = "sub_image2", columnDefinition = "LONGBLOB")
    private byte[] subImage2;

    @Lob
    @Column(name = "sub_image3", columnDefinition = "LONGBLOB")
    private byte[] subImage3;

    @Lob
    @Column(name = "sub_image4", columnDefinition = "LONGBLOB")
    private byte[] subImage4;

    private Double ratings = 0.0;
    private String review;
    private BigDecimal oldPrice;
    private Integer discount = 0;
    private String offers;
    private String keyHighlights;
    private String weight;
    private Integer quantity = 1;
    private String productDetails;
    private String cakeDetails;
    private String storageCare;
    private String ingredients;

    private Boolean isAvailable = true;
    private Boolean isFeatured = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Constructors
    public Product() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public ProductType getProductType() { return productType; }
    public void setProductType(ProductType productType) { this.productType = productType; }

    public byte[] getMainImage() { return mainImage; }
    public void setMainImage(byte[] mainImage) { this.mainImage = mainImage; }

    public byte[] getSubImage1() { return subImage1; }
    public void setSubImage1(byte[] subImage1) { this.subImage1 = subImage1; }

    public byte[] getSubImage2() { return subImage2; }
    public void setSubImage2(byte[] subImage2) { this.subImage2 = subImage2; }

    public byte[] getSubImage3() { return subImage3; }
    public void setSubImage3(byte[] subImage3) { this.subImage3 = subImage3; }

    public byte[] getSubImage4() { return subImage4; }
    public void setSubImage4(byte[] subImage4) { this.subImage4 = subImage4; }

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

    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }

    public Boolean getIsFeatured() { return isFeatured; }
    public void setIsFeatured(Boolean isFeatured) { this.isFeatured = isFeatured; }

    public Set<Category> getCategories() { return categories; }
    public void setCategories(Set<Category> categories) { this.categories = categories; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
