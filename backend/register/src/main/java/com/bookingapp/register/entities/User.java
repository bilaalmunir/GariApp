package com.bookingapp.register.entities;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//book details 
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userID;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany
    private List<Product> ownedCars;
    @OneToMany
    private List<Product> carsAdded;

    
    public List<Product> getCarsAdded() {
        return carsAdded;
    }
    public void setCarsAdded(List<Product> carsAdded) {
        this.carsAdded = carsAdded;
    }
    public List<Product> getOwnedCars() {
        return ownedCars;
    }
    public void setOwnedCars(List<Product> ownedCars) {
        this.ownedCars = ownedCars;
    }
  
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID =  userID;
    }
  
    public String getUserName() {
        return username;
    }
    public void setUserName(String userName) {
        this.username = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   }
    


