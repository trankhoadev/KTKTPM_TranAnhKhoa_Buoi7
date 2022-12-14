package com.demo.springsecurity.service;

import com.demo.springsecurity.entity.ChuyenBay;
import com.demo.springsecurity.entity.Product;
import com.demo.springsecurity.repository.ChuyenBayRepository;
import com.demo.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChuyenBayService {
    @Autowired
    private ChuyenBayRepository repo;

    public ChuyenBay get(long id) {
        return repo.findById(id).get();
    }

    public List<ChuyenBay> getAll() {
        return repo.findAll();
    }

    public void save(ChuyenBay chuyenBay) {
        repo.save(chuyenBay);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
