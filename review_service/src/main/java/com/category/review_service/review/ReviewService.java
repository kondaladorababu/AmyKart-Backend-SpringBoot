package com.category.review_service.review;

import java.util.List;

public interface ReviewService {
    List<Review> findByProductId(Integer productId);

    void createReview(Integer productId,Review review);

    Review getReviewById(Integer id);

    boolean updateReview(Integer id, Review review);

    boolean deleteReview(Integer id);
}
