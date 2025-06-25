package com.cs.cakeshop.Dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class ProductReviewResponseDto {

    private Long id;
    private Double totalRatings;
    private List<String> customerImages;
    private String customerName;
    private String approval;
    private Integer ratings;
    private LocalDateTime date;
    private String place;
    private String occasion;
    private String customerFeedback;
    private String customerUploadedImage;

    // Default constructor
    public ProductReviewResponseDto() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getTotalRatings() { return totalRatings; }
    public void setTotalRatings(Double totalRatings) { this.totalRatings = totalRatings; }

    public List<String> getCustomerImages() { return customerImages; }
    public void setCustomerImages(List<String> customerImages) { this.customerImages = customerImages; }

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

    public String getCustomerUploadedImage() { return customerUploadedImage; }
    public void setCustomerUploadedImage(String customerUploadedImage) { this.customerUploadedImage = customerUploadedImage; }
}

