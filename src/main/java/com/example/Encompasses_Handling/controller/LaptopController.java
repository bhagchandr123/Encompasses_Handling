package com.example.Encompasses_Handling.controller;

import com.example.Encompasses_Handling.service.LaptopService;
import com.example.Encompasses_Handling.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        List<Laptop> laptops = laptopService.getAllLaptops();
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable Long id) {
        Laptop laptop = laptopService.getLaptopById(id);
        if (laptop != null) {
            return new ResponseEntity<>(laptop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop) {
        Laptop createdLaptop = laptopService.createLaptop(laptop);
        return new ResponseEntity<>(createdLaptop, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable Long id, @RequestBody Laptop updatedLaptop) {
        Laptop laptop = laptopService.updateLaptop(id, updatedLaptop);
        if (laptop != null) {
            return new ResponseEntity<>(laptop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
