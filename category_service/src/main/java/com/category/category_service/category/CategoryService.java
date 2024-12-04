package com.category.category_service.category;

import com.category.category_service.category.clients.Product;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void createCategory(Category category);

    Category getCategoryById(Integer id);

    void updateCategory(Category category);

    void deleteCategory(Integer id);

    List<Product> getProductsByCategoryId(Integer categoryId);

}
