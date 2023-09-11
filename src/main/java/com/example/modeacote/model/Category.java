package com.example.modeacote.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="category")
@SequenceGenerator(name="category_gen",sequenceName="category_seq", initialValue = 1, allocationSize = 1)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    // Relation One-to-Many vers Product
    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL) // "category" fait référence à la propriété dans la classe Product
    private List<Product> products;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
