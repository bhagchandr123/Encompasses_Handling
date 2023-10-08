package com.example.Encompasses_Handling.service;

import com.example.Encompasses_Handling.model.Laptop;
import com.example.Encompasses_Handling.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(Long id) {
        Optional<Laptop> laptop = laptopRepository.findById(id);
        return laptop.orElse(null);
    }

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop updateLaptop(Long id, Laptop updatedLaptop) {
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if (laptop.isPresent()) {
            Laptop existingLaptop = laptop.get();
            existingLaptop.setName(updatedLaptop.getName());
            existingLaptop.setBrand(updatedLaptop.getBrand());
            existingLaptop.setPrice(updatedLaptop.getPrice());
            // Update other fields as needed
            return laptopRepository.save(existingLaptop);
        }
        return null;
    }

    public void deleteLaptop(Long id) {
        laptopRepository.deleteById(id);
    }
}
