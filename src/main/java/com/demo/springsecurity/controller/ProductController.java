package com.demo.springsecurity.controller;

import com.demo.springsecurity.entity.Product;
import com.demo.springsecurity.exception.ResourceNotFoundException;
import com.demo.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Product> getEmployeeById(@PathVariable  long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(product);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product product) {
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));


        updateProduct.setBrand(product.getBrand());
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());

        productRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id){

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
