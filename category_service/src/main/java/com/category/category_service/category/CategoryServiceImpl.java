package com.category.category_service.category;

import com.category.category_service.category.clients.Product;
import com.category.category_service.category.clients.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private ProductClient productClient;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
        if (existingCategory == null) {
            return;
        }
        existingCategory.setName(category.getName() != null ? category.getName() : existingCategory.getName());
        existingCategory.setImage(category.getImage() != null ? category.getImage() : existingCategory.getImage());
        categoryRepository.save(existingCategory);
    }

    @Override
    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productClient.getProductsByCategoryId(categoryId);
    }
}
