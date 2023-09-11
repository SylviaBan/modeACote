package com.example.modeacote.controller;

import com.example.modeacote.model.Product;
import com.example.modeacote.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService prodService;
    public ProductController(ProductService prodService) {
        this.prodService = prodService;
    }

    // CRUD
    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> tutorials = prodService.findAllProd();

        model.addAttribute("title","Liste des tutoriels");
        model.addAttribute("tutorialList", tutorials);

        return "home";
    }


    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        // Ajoutez le produit à la base de données
        prodService.addProd(product);
        return "redirect:/products/"; // Redirige vers la liste des produits
    }


    @PostMapping("/edit")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        // Mettez à jour le produit dans la base de données
        prodService.updateProd(id, product);
        return "redirect:/products/"; // Redirige vers la liste des produits
    }

    // Supprimer un produit
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        // Supprimez le produit de la base de données
        prodService.deleteProdById(id);
        return "redirect:/products/"; // Redirige vers la liste des produits
    }
}
