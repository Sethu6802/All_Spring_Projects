package com.example.demo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prodId;

    private String brand;
    private String desc;
    private int qty;
    private int price;
    
}