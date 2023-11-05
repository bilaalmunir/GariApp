package com.bookingapp.register.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookingapp.register.entities.Product;
import com.bookingapp.register.entities.User;
import com.bookingapp.register.repository.ProductRepository;
import com.bookingapp.register.repository.Userrepository;

import jakarta.validation.constraints.Null;
import java.util.List;

@Service

public class ProductServices {
     @Autowired
    private ProductRepository proRepo;
    @Autowired
    private Userrepository userRepo;

   public Product addCar(String carName,String model,String color,int userId){
      Product Carinfo =  new Product(carName,model,color,userId);
      proRepo.save(Carinfo);
      return Carinfo;
   }
    public String deleteCar(int carId){
            proRepo.deleteById(carId);
            return "Info has been deleted!";
    }
         
    public String buyCar (int carId, int userID){
           
        Optional<Product> carOptional = proRepo.findById(carId);
             if (carOptional.isPresent()){
                Product car = carOptional.get(); // Retrieve the Product object
                car.setStatus(true); 
                
                        Optional<User> userOptional = userRepo.findById((long) userID);
                         if (carOptional.isPresent()){
                                User user= userOptional.get();
                                List<Product> ownedCars = user.getOwnedCars();
                                ownedCars.add(car);
                proRepo.save(car);
                                userRepo.save(user);   
                                 return "You have successfully bought the car!";
                         } else {
                            return "User not found with ID: " + userID;
                         }
                }
                return "Car not found with ID: " + carId;
            }

           
     public List<Product> getAllUnsoldCars(){
       return proRepo.findByStatus(false);
    }    
    // public List<Product> findAllUnsoldCars() {
    //     List<Product> allProducts = proRepo.findAll();
        
    //     // Filter products with status = false using Java streams
    //     List<Product> productsWithStatusFalse = allProducts.stream()
    //             .filter(product -> !product.getStatus())
    //             .collect(Collectors.toList());

    //     return productsWithStatusFalse;
    // }
    public List<Product> getAllSoldCars(){
       return proRepo.findByStatus(true);
    }  
    public List<Product> getAllCars(){
        return proRepo.findAll();
    }
    }

