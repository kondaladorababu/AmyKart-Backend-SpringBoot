package com.category.review_service.review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int userId;

//    @ManyToOne
//    @JsonBackReference
//    private Product product;

    private int rating;
    private String review;


    public Review() {
    }

    //constructor
    public Review(int userId, int rating, String review) {
        this.userId = userId;
        this.rating = rating;
        this.review = review;
    }

//    public Review(int userId, Product product, int rating, String review) {
//        this.userId = userId;
//        this.product = product;
//        this.rating = rating;
//        this.review = review;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
