package com.category.product_service.product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void createProduct(Product product);

    Product getProductById(Integer id);

    void deleteProduct(Integer id);

    boolean updateProduct(Integer id, Product product);

    List<Product> findProductsByCategoryId(Integer categoryId);
}
