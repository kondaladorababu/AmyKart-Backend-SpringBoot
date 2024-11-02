package com.example.product_service.product;

import java.util.List;

public class ProductResponseDTO {

    private final int id;
    private final String title;
    private final double price;
    private final String description;
//    private final Integer categoryId;
    private final String imageUrl;
//    private final List<Review> reviews;

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
//        this.categoryId = product.getCategory().getId();
        this.imageUrl = "/products/image/" + product.getId();
//        this.reviews = product.getReview();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

//    public Integer getCategoryId() {
//        return categoryId;
//    }

    public String getImage() {
        return imageUrl;
    }

//    public List<Review> getReviews() {
//        return reviews;
//    }
}
