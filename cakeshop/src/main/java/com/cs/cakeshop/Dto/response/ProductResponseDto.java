package com.cs.cakeshop.Dto.response;

import java.util.List;

public class ProductResponseDto {

    private Long id;
    private String type;
    private String productName;
    private Double ratings;
    private Integer reviews;
    private Double productOldPrice;
    private Double productNewPrice;
    private String productDiscount;
    private OrchidsDto orchids;
    private List<Double> weight;
    private String nameOnCake;
    private String address;
    private List<String> offers;
    private List<String> productContains;
    private String description;
    private List<String> careInstructions;
    private String skuNumber;
    private String note;
    private String productImage;
    private List<String> productSubImages;

    // Inner class for orchids
    public static class OrchidsDto {
        private BasicDto Basic;
        private WithOrchidsDto WithOrchids;

        public BasicDto getBasic() {
            return Basic;
        }

        public void setBasic(BasicDto basic) {
            Basic = basic;
        }

        public WithOrchidsDto getWithOrchids() {
            return WithOrchids;
        }

        public void setWithOrchids(WithOrchidsDto withOrchids) {
            WithOrchids = withOrchids;
        }
    }

    public static class BasicDto {
        private String image;
        private String title;
        private Double price;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    public static class WithOrchidsDto {
        private String image;
        private String title;
        private Double price;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    // Default constructor
    public ProductResponseDto() {}

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

    public OrchidsDto getOrchids() {
        return orchids;
    }

    public void setOrchids(OrchidsDto orchids) {
        this.orchids = orchids;
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public List<String> getProductSubImages() {
        return productSubImages;
    }

    public void setProductSubImages(List<String> productSubImages) {
        this.productSubImages = productSubImages;
    }
}
