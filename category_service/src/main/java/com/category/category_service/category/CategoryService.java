package com.category.category_service.category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void createCategory(Category category);

    Category getCategoryById(Integer id);

    void deleteCategory(Integer id);

    void updateCategory(Category category);

}
