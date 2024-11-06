package com.category.product_service.product;

//import com.example.product_service.category.Category;
//import com.example.product_service.review.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String title;
    private double price;
    private String description;

//    @ManyToOne
//    @JsonBackReference
//    private Category category;

    @Lob
    private byte[] image;

//    @OneToMany(mappedBy = "product",
//            fetch = FetchType.LAZY,
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//
//    private List<Review> reviews;

    public Product() {
    }

//    public Product(String title, double price, String description, Category category, byte[] image, List<Review> reviews) {
//        this.title = title;
//        this.price = price;
//        this.description = description;
//        this.category = category;
//        this.image = image;
//        this.reviews = reviews;
//    }

    public Product(String title, double price, String description, byte[] bytes) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = bytes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

//    public List<Review> getReview() {
//        return reviews;
//    }
//
//    public void setReview(List<Review> reviews) {
//        this.reviews = reviews;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
//                ", category='" + category + '\'' +
                ", image=" + image +
//                ", review=" + reviews +
                '}';
    }
}

//
//and sql query for rating table
//    CREATE TABLE rating (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    rate DOUBLE,
//    count INT
//    )

//    how to store the image  in db
//    CREATE TABLE product (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    title VARCHAR(255),
//    price DOUBLE,
//    description VARCHAR(255),
//    category VARCHAR(255),
//    image BLOB,
//    rating_id INT,
//    FOREIGN KEY (rating_id) REFERENCES rating(id)
//            )

