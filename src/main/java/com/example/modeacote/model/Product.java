package com.example.modeacote.model;

import jakarta.persistence.*;

@Entity
@Table(name="clothes")
@SequenceGenerator(name="product_gen",sequenceName="product_seq", initialValue = 1, allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private String size;
    private String material;
    private String brand;

    public Product(Long id, String name, String color, String size, String material, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.material = material;
        this.brand = brand;
    }

    public Product(String name, String color, String size, String material, String brand) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.material = material;
        this.brand = brand;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
