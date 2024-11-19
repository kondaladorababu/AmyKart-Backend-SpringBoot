package com.category.product_service.product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    Product getProductById(Integer id);

    boolean updateProduct(Integer id, Product product);

    void deleteProduct(Integer id);


    List<ProductResponseDTO> findAll();

    List<ProductResponseDTO> findProductsByCategoryId(Integer categoryId);
}
