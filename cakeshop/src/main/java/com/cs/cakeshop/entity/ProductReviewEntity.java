package com.cs.cakeshop.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_reviews")
public class ProductReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_ratings")
    private Double totalRatings;

    @Lob
    @Column(name = "customer_images", columnDefinition = "LONGBLOB")
    private byte[] customerImages;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "approval")
    private String approval;

    @Column(name = "ratings")
    private Integer ratings;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "place")
    private String place;

    @Column(name = "occasion")
    private String occasion;

    @Column(name = "customer_feedback", columnDefinition = "TEXT")
    private String customerFeedback;

    @Lob
    @Column(name = "customer_uploaded_image", columnDefinition = "LONGBLOB")
    private byte[] customerUploadedImage;

    // Default constructor
    public ProductReviewEntity() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getTotalRatings() { return totalRatings; }
    public void setTotalRatings(Double totalRatings) { this.totalRatings = totalRatings; }

    public byte[] getCustomerImages() { return customerImages; }
    public void setCustomerImages(byte[] customerImages) { this.customerImages = customerImages; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getApproval() { return approval; }
    public void setApproval(String approval) { this.approval = approval; }

    public Integer getRatings() { return ratings; }
    public void setRatings(Integer ratings) { this.ratings = ratings; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public String getOccasion() { return occasion; }
    public void setOccasion(String occasion) { this.occasion = occasion; }

    public String getCustomerFeedback() { return customerFeedback; }
    public void setCustomerFeedback(String customerFeedback) { this.customerFeedback = customerFeedback; }

    public byte[] getCustomerUploadedImage() { return customerUploadedImage; }
    public void setCustomerUploadedImage(byte[] customerUploadedImage) { this.customerUploadedImage = customerUploadedImage; }
}
