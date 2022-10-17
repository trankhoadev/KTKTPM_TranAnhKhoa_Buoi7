package com.demo.springsecurity.service;

import com.demo.springsecurity.entity.Product;
import com.demo.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public Product get(long id) {
        return repo.findById(id).get();
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
