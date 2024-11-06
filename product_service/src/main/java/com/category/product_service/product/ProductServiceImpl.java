package com.category.product_service.product;

//import com.example.product_service.category.Category;
//import com.example.product_service.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

//    @Autowired
//    private final CategoryRepository categoryRepository;

//    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//    }

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void createProduct(Integer categoryId, Product product) {
//        Category category = categoryRepository.findById(categoryId).orElse(null);
//        if (category == null) {
//            return;
//        }
//        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean updateProduct(Integer id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return false;
        }
        existingProduct.setTitle(product.getTitle() != null ? product.getTitle() : existingProduct.getTitle());
        existingProduct.setPrice(product.getPrice() != 0 ? product.getPrice() : existingProduct.getPrice());
        existingProduct.setDescription(product.getDescription() != null ? product.getDescription() : existingProduct.getDescription());
        existingProduct.setImage(product.getImage() != null ? product.getImage() : existingProduct.getImage());
        productRepository.save(existingProduct);
        return true;
    }

//    @Override
//    public List<Product> findProductsByCategoryId(Integer categoryId) {
//        return productRepository.findProductsByCategoryId(categoryId);
//    }
}
