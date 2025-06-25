package com.cs.cakeshop.Dto.request;

import java.time.LocalDate;
import java.util.List;

public class DiscountRequestDto {
    private String discountCode;
    private String description;
    private String discountType;
    private Double discountValue;
    private Double minimumOrderAmount;
    private Double maximumDiscountAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String applicabilityType;
    private List<String> categories;
    private Integer usageLimit;
    private String status;

    // Constructors
    public DiscountRequestDto() {}

    // Getters and Setters
    public String getDiscountCode() { return discountCode; }
    public void setDiscountCode(String discountCode) { this.discountCode = discountCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDiscountType() { return discountType; }
    public void setDiscountType(String discountType) { this.discountType = discountType; }

    public Double getDiscountValue() { return discountValue; }
    public void setDiscountValue(Double discountValue) { this.discountValue = discountValue; }

    public Double getMinimumOrderAmount() { return minimumOrderAmount; }
    public void setMinimumOrderAmount(Double minimumOrderAmount) { this.minimumOrderAmount = minimumOrderAmount; }

    public Double getMaximumDiscountAmount() { return maximumDiscountAmount; }
    public void setMaximumDiscountAmount(Double maximumDiscountAmount) { this.maximumDiscountAmount = maximumDiscountAmount; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getApplicabilityType() { return applicabilityType; }
    public void setApplicabilityType(String applicabilityType) { this.applicabilityType = applicabilityType; }

    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }

    public Integer getUsageLimit() { return usageLimit; }
    public void setUsageLimit(Integer usageLimit) { this.usageLimit = usageLimit; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
