package com.category.review_service.review;

//import com.example.product_service.product.Product;
//import com.example.product_service.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private final ReviewRepository reviewRepository;
//    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

//    @Override
//    public List<Review> findByProductId(Integer productId) {
//        Product product = productRepository.findById(productId)
//                .orElse(null);
//        if (product == null) {
//            return null;
//        }
//        return product.getReview();
//    }

    @Override
    public void createReview(Integer productId, Review review) {
//        Product product = productRepository.findById(productId)
//                .orElse(null);
//
//        //never happens
//        if (product == null) {
//            return;
//        }
//        review.setProduct(product);
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Integer id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateReview(Integer id, Review review) {
        if (reviewRepository.existsById(id)) {
            Review existingReview = reviewRepository.findById(id).orElse(null);
            if (existingReview != null) {
                existingReview.setRating(review.getRating());
                existingReview.setReview(review.getReview());
                reviewRepository.save(existingReview);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteReview(Integer id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
