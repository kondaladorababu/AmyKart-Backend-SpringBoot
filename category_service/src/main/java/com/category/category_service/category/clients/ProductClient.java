package com.category.category_service.category.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8082")
public interface ProductClient {

    @GetMapping("/products/category/{categoryId}")
    List<Product> getProductsByCategoryId(@PathVariable("categoryId") Integer categoryId);
}
