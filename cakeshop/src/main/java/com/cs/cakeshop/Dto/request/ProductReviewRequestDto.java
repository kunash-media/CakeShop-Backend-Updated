package com.cs.cakeshop.Dto.request;

import java.time.LocalDateTime;

public class ProductReviewRequestDto {

    private Double totalRatings;
    private String customerName;
    private String approval;
    private Integer ratings;
    private LocalDateTime date;
    private String place;
    private String occasion;
    private String customerFeedback;

    // Default constructor
    public ProductReviewRequestDto() {}

    // Getters and Setters
    public Double getTotalRatings() { return totalRatings; }
    public void setTotalRatings(Double totalRatings) { this.totalRatings = totalRatings; }

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
}

