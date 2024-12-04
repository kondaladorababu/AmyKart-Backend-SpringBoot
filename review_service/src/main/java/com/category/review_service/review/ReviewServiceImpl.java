package com.category.review_service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void createReview(Integer productId, Review review) {
        review.setProductId(productId);
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

    @Override
    public List<Review> findByProductId(Integer productId) {
       List<Review> reviews =  reviewRepository.findReviewsByProductId(productId);
       if(reviews.isEmpty()){
           return null;
       }
       return reviews;
    }

    @Override
    public void deleteReviewsByProductId(Integer productId) {
        List<Review> reviews = reviewRepository.findReviewsByProductId(productId);
        for (Review review : reviews) {
            reviewRepository.deleteById(review.getId());
        }
    }

}
