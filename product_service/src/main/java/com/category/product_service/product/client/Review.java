package com.category.product_service.product.client;

public class Review {
    private int userId;
    private int rating;
    private String review;

    public Review() {
    }

    public Review(int userId, int rating, String review) {
        this.userId = userId;
        this.rating = rating;
        this.review = review;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
