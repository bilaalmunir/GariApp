package com.bookingapp.register.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//cars details 
@Entity
@Table(name="cars")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int ID;

    private String carName;
    private String model;
    private String color;
    private Boolean status=false;
    private int publishedBy;

    public Product(){}
    public Product(String carName, String model, String color, int publishedBy) {
        this.carName = carName;
        this.model = model;
        this.color = color;
        this.publishedBy = publishedBy;
    }
    public int getPublishedBy() {
        return publishedBy;
    }
    public void setPublishedBy(int publishedBy) {
        this.publishedBy = publishedBy;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean Status) {
        status = Status;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String Model) {
        model = Model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String Color) {
        color = Color;
    }
    

    
}
