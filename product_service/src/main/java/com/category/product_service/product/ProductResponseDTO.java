package com.category.product_service.product;

import com.category.product_service.product.client.Review;

import java.util.List;

public class ProductResponseDTO {

    private final String title;
    private final double price;
    private final String description;
    private final String imageUrl;
    private final Integer categoryId;
    private List<Review> reviews;

    public ProductResponseDTO(Product product, List<Review> reviews) {
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = "/products/image/" + product.getId();;
        this.categoryId = product.getCategoryId();
        this.reviews = reviews;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
