package com.example.modeacote.controller;

import com.example.modeacote.model.Product;
import com.example.modeacote.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService prodService;
    public ProductController(ProductService prodService) {
        this.prodService = prodService;
    }

    // CRUD
    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> productsList = prodService.listAll();
        model.addAttribute("productsList", productsList);
        return "products";
    }

    private List<Product> products = new ArrayList<>();
    @GetMapping("/products/add")
    public String showAddForm(@ModelAttribute Product product) {
        products.add(product);
        return "add-form";
    }
    @PostMapping("/rootList")
    public String rootList(Model model) {
        return "products";
    }


    @PostMapping("/products/edit")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        // Mettez à jour le produit dans la base de données
        prodService.updateProd(id, product);
        return "products";
    }

    // Supprimer un produit
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        prodService.deleteProdById(id);
        return "delete-confirm";
    }
    @PostMapping("/products/delete")
    public String rootToList(Model model) {
        List<Product> products = prodService.listAll();
        model.addAttribute("products", products);
        return "products";
    }
}
