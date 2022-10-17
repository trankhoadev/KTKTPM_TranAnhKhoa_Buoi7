package com.demo.springsecurity.repository;

import com.demo.springsecurity.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }
