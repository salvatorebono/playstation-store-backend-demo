package it.lipari.accademy.controller;

import it.lipari.accademy.entity.ProductEntity;
import it.lipari.accademy.model.ProductModel;
import it.lipari.accademy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductEntity>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductEntity>> getElementById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getElementById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PostMapping("/")
    public ResponseEntity<ProductEntity> save(@RequestBody ProductModel body) {
        return ResponseEntity.ok(productService.addProduct(body));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> editProduct(@PathVariable Long id, @RequestBody ProductModel body) {
        return ResponseEntity.ok(productService.editProduct(id, body));
    }


}

