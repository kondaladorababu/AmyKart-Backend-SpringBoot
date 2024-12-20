package com.category.product_service.product;

import com.category.product_service.product.client.Review;
import com.category.product_service.product.client.ReviewClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*") // Enable CORS
public class ProductController {

    private final ProductService productService;

    @Autowired
    private ReviewClient reviewClient;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //for Development purpose
    @PostMapping("/add/{categoryId}")
    public ResponseEntity<String> addProduct(@PathVariable("categoryId") Integer categoryId,
                                             @RequestParam("title") String title,
                                             @RequestParam("price") double price,
                                             @RequestParam("description") String description,
                                             @RequestParam("image") MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            return new ResponseEntity<>("Image not found", HttpStatus.BAD_REQUEST);
        }

        if (!image.getContentType().equals("image/jpeg")) {
            return new ResponseEntity<>("Only JPEG images are allowed", HttpStatus.BAD_REQUEST);
        }

        Product newProduct = new Product(title, price, description, image.getBytes(), categoryId);

        productService.createProduct(newProduct);
        return ResponseEntity.ok("Product added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Review> reviews = reviewClient.getReviewsByProductId(id);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO(product, reviews);
        return ResponseEntity.ok(productResponseDTO);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> getProductImage(@PathVariable int id) {
        Optional<Product> product = Optional.ofNullable(productService.getProductById(id));
        if (product.isEmpty()) {
            return new ResponseEntity<>("Product not found to get Image", HttpStatus.NOT_FOUND);
        }
        byte[] image = product.get().getImage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "image/jpeg");
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        boolean updated = productService.updateProduct(id, product);
        if (updated) {
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }



    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategoryId(@PathVariable Integer categoryId) {
        List<ProductResponseDTO> products = productService.findProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }


}


