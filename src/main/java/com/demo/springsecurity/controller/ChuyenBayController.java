package com.demo.springsecurity.controller;

import com.demo.springsecurity.entity.ChuyenBay;
import com.demo.springsecurity.entity.Product;
import com.demo.springsecurity.exception.ResourceNotFoundException;
import com.demo.springsecurity.repository.ChuyenBayRepository;
import com.demo.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@Controller
@RequestMapping("/chuyen-bay")
public class ChuyenBayController {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

    @GetMapping
    public List<ChuyenBay> getAllChuyenBay(){
        return chuyenBayRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public ChuyenBay createChuyenBay(@RequestBody ChuyenBay chuyenBay) {
        return chuyenBayRepository.save(chuyenBay);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<ChuyenBay> getChuyenBay(@PathVariable  long id){
        ChuyenBay product = chuyenBayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ChuyenBay not exist with id:" + id));
        return ResponseEntity.ok(product);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<ChuyenBay> updateChuyenBay(@PathVariable long id,@RequestBody ChuyenBay chuyenBay) {
        ChuyenBay updateChuyenBay = chuyenBayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ChuyenBay not exist with id: " + id));


        updateChuyenBay.setGaDen(chuyenBay.getGaDen());
        updateChuyenBay.setGaDi(chuyenBay.getGaDi());
        updateChuyenBay.setMaCb(chuyenBay.getMaCb());

        chuyenBayRepository.save(updateChuyenBay);

        return ResponseEntity.ok(updateChuyenBay);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteChuyenBay(@PathVariable long id){

        ChuyenBay product = chuyenBayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        chuyenBayRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
