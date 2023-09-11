package com.example.modeacote.controller;

import com.example.modeacote.model.Product;
import com.example.modeacote.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/")
public class ProductController {
    private ProductService prodService;
    public ProductController(ProductService prodService) {
        this.prodService = prodService;
    }

    @GetMapping("/home")
    public String accueil() {
        return "home"; // Spring ajoutera automatiquement le préfixe et l'extension pour trouver "templates/home.html"
    }

    // CRUD
    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = prodService.findAllProd();
        model.addAttribute("products", products);
        return "list";
    }


    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        // Ajoutez le produit à la base de données
        prodService.addProd(product);
        return "list";
    }


    @PostMapping("/edit")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        // Mettez à jour le produit dans la base de données
        prodService.updateProd(id, product);
        return "list";    }

    // Supprimer un produit
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        prodService.deleteProdById(id);
        return "list";
    }
}
