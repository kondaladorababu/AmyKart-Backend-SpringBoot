package com.category.category_service.category.clients;

public class Review {

    private int id;
    private int userId;
    private int rating;
    private int productId;
    private String review;

    public Review() {
    }

    public Review(int userId, int rating, String review, int productId) {
        this.userId = userId;
        this.rating = rating;
        this.review = review;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public int getProductId() {
        return productId;
    }

}
