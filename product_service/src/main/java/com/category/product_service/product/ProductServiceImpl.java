package com.category.product_service.product;

import com.category.product_service.product.client.Review;
import com.category.product_service.product.client.ReviewClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private ReviewClient reviewClient;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        Product product =  productRepository.findById(id).orElse(null);
        return product;
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

    @Override
    public void deleteProduct(Integer id) {
        reviewClient.deleteReviewsByProductId(id);
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDTO> findProductsByCategoryId(Integer categoryId) {
        List<Product> products = productRepository.findProductsByCategoryId(categoryId);
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<ProductResponseDTO>();

        for (Product product : products) {
            List<Review> reviews = reviewClient.getReviewsByProductId(product.getId());
            productResponseDTOS.add(new ProductResponseDTO(product, reviews));
        }

        return productResponseDTOS;
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<ProductResponseDTO>();

        for (Product product : products) {
            List<Review> reviews = reviewClient.getReviewsByProductId(product.getId());
            productResponseDTOS.add(new ProductResponseDTO(product, reviews));
        }

        return productResponseDTOS;
    }
}
