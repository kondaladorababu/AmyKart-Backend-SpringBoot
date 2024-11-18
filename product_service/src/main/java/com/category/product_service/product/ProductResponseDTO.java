package com.category.product_service.product;

public class ProductResponseDTO {

    private final int id;
    private final String title;
    private final double price;
    private final String description;
    private final String imageUrl;
    private final Integer categoryId;

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = "/products/image/" + product.getId();
        this.categoryId = product.getCategoryId();
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

//    public List<Review> getReviews() {
//        return reviews;
//    }
}
