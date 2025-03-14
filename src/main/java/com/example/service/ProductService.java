
package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create a new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // Update product by ID
    public Product updateProduct(String id, Product updatedProduct) {
        return productRepository.findById(id).map(existingProduct -> {
            if (updatedProduct.getName() != null) existingProduct.setName(updatedProduct.getName());
            if (updatedProduct.getDescription() != null) existingProduct.setDescription(updatedProduct.getDescription());
            if (updatedProduct.getPrice() != 0) existingProduct.setPrice(updatedProduct.getPrice());
            if (updatedProduct.getQuantity() != 0) existingProduct.setQuantity(updatedProduct.getQuantity());
            if (updatedProduct.getCategory() != null) existingProduct.setCategory(updatedProduct.getCategory());
            return productRepository.save(existingProduct);
        }).orElse(null);
    }

    // Delete product by ID
    public boolean deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
