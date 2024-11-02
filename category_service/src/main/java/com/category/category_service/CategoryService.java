package com.category.category_service;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void createCategory(Category category);

    Category getCategoryById(Integer id);

    void deleteCategory(Integer id);

    void updateCategory(Category category);

}
