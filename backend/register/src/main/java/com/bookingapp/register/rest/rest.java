package com.bookingapp.register.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingapp.register.entities.Product;
import com.bookingapp.register.entities.User;
import com.bookingapp.register.service.ProductServices;
import com.bookingapp.register.service.UserServices;

@org.springframework.stereotype.Controller
@RestController    
public class rest {
    @Autowired
    private ProductServices ps ;
    @Autowired
    private UserServices us;


    @PostMapping("/registerUser")
    public User registerUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname,
            @RequestParam String email, @RequestParam String password) {
        return us.registerUser(username, firstname, lastname, email, password);
    }

    @PostMapping("/loginUser")
    public User loginUser(@RequestParam String username,@RequestParam String password){
        return us.loginUser(username, password);
    }
    

    // @PostMapping("/addCar")
    // public String addCar (@RequestParam String carInfo, @RequestParam int userID){

    //     return "working";
    // }
    @PostMapping("/addCar")
    public Product addCar(@RequestParam String carName, @RequestParam String model, @RequestParam String color, @RequestParam int userId ){
        return ps.addCar(carName,model,color,userId);
    }

    
    //@RequestParam String carInfo, @RequestParam int userID

    //   @PostMapping("/addCar")
    // public Product addCar (@RequestParam Product carInfo, @RequestParam int userID){
    //     return ps.addCar(carInfo,userID);

    @DeleteMapping("/deleteCar/{ID}")
    public String deleteCar(@RequestParam int ID) {
        return ps.deleteCar(ID);
    }
    @PutMapping("/buyCar/")
    public String buyCar (@RequestParam int carID, @RequestParam int userID){
        return ps.buyCar(carID,userID);
    }

    @GetMapping("/getAllUnsoldCars")
    public List<Product> getAllUnsoldCars(){
        return ps.getAllUnsoldCars();}

        // @GetMapping("/findAllUnsoldCars")
        // public List<Product> findAllUnsoldCars(){
        //     return ps.findAllUnsoldCars();
        // }
    @GetMapping("/getAllSoldCars")
    public List<Product> getAllSoldCars(){
        return ps.getAllSoldCars();}
    
    @GetMapping("/getAllCars")
    public List<Product> getAllCars(){
        return ps.getAllCars();
    }    
    }

