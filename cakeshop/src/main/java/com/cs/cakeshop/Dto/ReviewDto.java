package com.cs.cakeshop.Dto;

public class ReviewDto {
    private String customerName;
    private Integer customerRatings;
    private String customerMessage;
    private String customerFeedback;

    public ReviewDto() {}

    public ReviewDto(String customerName, Integer customerRatings, String customerMessage, String customerFeedback) {
        this.customerName = customerName;
        this.customerRatings = customerRatings;
        this.customerMessage = customerMessage;
        this.customerFeedback = customerFeedback;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerRatings() {
        return customerRatings;
    }

    public void setCustomerRatings(Integer customerRatings) {
        this.customerRatings = customerRatings;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    public String getCustomerFeedback() {
        return customerFeedback;
    }

    public void setCustomerFeedback(String customerFeedback) {
        this.customerFeedback = customerFeedback;
    }
}

