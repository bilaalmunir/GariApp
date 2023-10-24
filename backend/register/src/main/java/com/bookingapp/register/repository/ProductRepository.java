package com.bookingapp.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingapp.register.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByStatus(Boolean status);
   

}
