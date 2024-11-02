package com.category.category_service;

public class CategoryResponse {
    private final int id;
    private final String name;
    private final String image;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.image = "/category/image/" + category.getId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
