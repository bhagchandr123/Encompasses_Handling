package com.example.Encompasses_Handling.repository;

import com.example.Encompasses_Handling.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
