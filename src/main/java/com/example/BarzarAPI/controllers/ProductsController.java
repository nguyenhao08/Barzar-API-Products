package com.example.BarzarAPI.controllers;

import com.example.BarzarAPI.models.Category;
import com.example.BarzarAPI.models.Products;
// import com.example.BarzarAPI.models.Products;
import com.example.BarzarAPI.repositories.ProductsRepository;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = { "https://react-workshop-wheat.vercel.app", "http://localhost:3000" })

public class ProductsController {

  @Autowired
  private ProductsRepository productsRepository;

  @GetMapping
  public List<Products> getAllProducts() {
    return productsRepository.findAll();
  }

  @GetMapping("/latest")
  public List<Products> getLatestProducts() {
    // Sắp xếp theo id giảm dần và giới hạn kết quả trả về là 3 sản phẩm
    return productsRepository.findAll(
        PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "id"))).getContent();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getProductById(@PathVariable Long id) {
    // Kiểm tra xem sản phẩm có tồn tại không
    Optional<Products> productOptional = productsRepository.findById(id);

    if (productOptional.isPresent()) {
      // Nếu sản phẩm tồn tại, trả về nó
      Products product = productOptional.get();
      return ResponseEntity.ok(product);
    } else {
      // Nếu sản phẩm không tồn tại, trả về phản hồi không tìm thấy (404)
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for " + id);
    }
  }

  @PostMapping
  public ResponseEntity<Products> createProducts(@RequestBody Products products, HttpServletRequest request) {
    String token = request.getHeader("Authorization");

    // Thực hiện kiểm tra trước khi lưu sản phẩm mới
    if (products.getId() != null) {
      Optional<Products> existingProduct = productsRepository.findById(products.getId());
      if (existingProduct.isPresent()) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // Trả về 409 Conflict nếu sản phẩm đã tồn tại
      }
    }

    // Thiết lập giá trị cho cột "createdAt" trước khi lưu vào cơ sở dữ liệu
    products.setCreatedAt(LocalDateTime.now());

    products.setgetUpdatedAt(LocalDateTime.now());

    Products newProduct = productsRepository.save(products);
    return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Products> updateUser(@PathVariable Long id, @RequestBody Products products) {
    // Kiểm tra xem sản phẩm có tồn tại không
    if (!productsRepository.existsById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Trả về 404 Not Found nếu sản phẩm không tồn tại
    }

    Products existingProduct = productsRepository.findById(id).get();
    existingProduct.setTitle(products.getTitle());
    existingProduct.setDescription(products.getDescription());

    Products updatedProduct = productsRepository.save(existingProduct);
    return ResponseEntity.ok(updatedProduct);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
    // Kiểm tra xem sản phẩm có tồn tại không
    if (!productsRepository.existsById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found"); // Trả về 404 Not Found nếu sản
                                                                                    // phẩm không tồn tại
    }

    productsRepository.deleteById(id);
    return ResponseEntity.ok("Product deleted successfully");
  }

}
