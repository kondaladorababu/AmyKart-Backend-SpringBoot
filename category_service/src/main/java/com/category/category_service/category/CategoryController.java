package com.category.category_service.category;

import com.category.category_service.category.clients.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.findAll().stream().map(CategoryResponse::new).toList();
        return ResponseEntity.ok(categories);
    }

    //for Developer purpose
    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestParam("name") String name,
                                              @RequestParam("image") MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            return new ResponseEntity<>("Image not found", HttpStatus.BAD_REQUEST);
        }

        if (!image.getContentType().equals("image/jpeg")) {
            return new ResponseEntity<>("Only JPEG images are allowed", HttpStatus.BAD_REQUEST);
        }
        Category category = new Category(name, image.getBytes());
        categoryService.createCategory(category);
        return ResponseEntity.ok("Category added successfully");
    }

    //By user view it never happens
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Integer id) {
        if (categoryService.getCategoryById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        CategoryResponse category = new CategoryResponse(categoryService.getCategoryById(id));
        return ResponseEntity.ok(category);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> getCategoryImage(@PathVariable Integer id) {
        Optional<Category> category = Optional.ofNullable(categoryService.getCategoryById(id));
        if (category.isEmpty()) {
            return new ResponseEntity<>("Category Image not found", HttpStatus.NOT_FOUND);
        }
        byte[] image = category.get().getImage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "image/jpeg");
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Integer id,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("image") MultipartFile image) throws IOException {
        Category category = categoryService.getCategoryById(id);

        if (!image.getContentType().equals("image/jpeg")) {
            return new ResponseEntity<>("Only JPEG images are allowed", HttpStatus.BAD_REQUEST);
        }

        if (image.isEmpty() && !name.isEmpty()) {
            category.setName(name);
            categoryService.updateCategory(category);
            return ResponseEntity.ok("Category updated successfully");
        }

        if (name.isEmpty() && !image.isEmpty()) {
            category.setImage(image.getBytes());
            categoryService.updateCategory(category);
            return ResponseEntity.ok("Category updated successfully");
        }

        if (name.isEmpty() && image.isEmpty()) {
            return new ResponseEntity<>("Name and Image not found", HttpStatus.BAD_REQUEST);
        }

        category.setName(name);
        category.setImage(image.getBytes());
        categoryService.updateCategory(category);
        return ResponseEntity.ok("Category updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        if (categoryService.getCategoryById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }

    //get products based on category id
    @GetMapping("/products/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Integer categoryId) {
        List<Product> products = categoryService.getProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }
}
