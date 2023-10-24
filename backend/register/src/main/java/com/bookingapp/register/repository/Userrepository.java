package com.bookingapp.register.repository;

import java.util.function.LongFunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingapp.register.entities.User;

@Repository
public interface Userrepository extends JpaRepository<User,Long>{

    public User findByUsername(String username);
    
}
