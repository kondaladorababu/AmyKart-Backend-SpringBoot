package com.category.category_service.category.clients;

import java.util.List;

public class Product {

    private final int id;
    private final String title;
    private final double price;
    private final String description;
    private final String imageUrl;
    private final Integer categoryId;
    List<Review> reviews;

    public Product(int id, String title, double price, String description, String imageUrl, Integer categoryId, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.reviews = reviews;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getImage() {
        return imageUrl;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
