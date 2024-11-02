package com.category.review_service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<String> createReview(@PathVariable("productId") Integer productId,  @RequestBody Review review) {
        reviewService.createReview(productId,review);
        return new ResponseEntity<>("Created ReviewStr", HttpStatus.CREATED);
    }

    //Will not available in frontend for user experience
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Integer id) {
        Review review = reviewService.getReviewById(id);
        if (review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

//    @GetMapping("/product/{productId}")
//    public ResponseEntity<?> getAllReviews(@PathVariable Integer productId) {
//        List<Review> reviews = reviewService.findByProductId(productId);
//        if (reviews == null) {
//            return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(reviews,HttpStatus.OK);
//    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Integer reviewId,
                                               @RequestBody Review review) {
        boolean isUpdated = reviewService.updateReview(reviewId, review);
        if (!isUpdated) {
            return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Review",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Integer id) {
        boolean isDeleted = reviewService.deleteReview(id);
        if (!isDeleted) {
            return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Deleted Review",HttpStatus.OK);
    }
}