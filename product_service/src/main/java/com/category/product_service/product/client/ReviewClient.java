package com.category.product_service.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "review-service", url = "http://localhost:8083")
public interface ReviewClient {

    @GetMapping("/review/all/product/{productId}")
    List<Review> getReviewsByProductId(@PathVariable("productId") Integer productId);

    @DeleteMapping("/review/all/product/{productId}")
    void deleteReviewsByProductId(@PathVariable("productId") int productId);

}
