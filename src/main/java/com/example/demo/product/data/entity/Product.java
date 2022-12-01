package com.example.demo.product.data.entity;

import jakarta.persistence.*;

@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long pId;
    @Column
    private String name;
    @Column
    private double price;

    public Product(long id, String name, double price) {
        this.pId = id;
        this.name = name;
        this.price = price;
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public long getId() {
        return pId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.pId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}