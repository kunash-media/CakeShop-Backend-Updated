package com.cs.cakeshop.Dto;

import java.math.BigDecimal;

public class ProductWeightDto {
    private String weight;
    private BigDecimal price;

    public ProductWeightDto() {}

    public ProductWeightDto(String weight, BigDecimal price) {
        this.weight = weight;
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
