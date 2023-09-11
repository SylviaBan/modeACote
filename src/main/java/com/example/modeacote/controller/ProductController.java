package com.example.modeacote.controller;

import com.example.modeacote.model.Product;
import com.example.modeacote.service.ProductService;
import com.example.modeacote.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // RETRIEVE ------------------------------
    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> productsList = prodService.listAll();
        model.addAttribute("productsList", productsList);
        return "products";
    }

    // CREATE ------------------------------
    private List<Product> products = new ArrayList<>();
    @GetMapping("/products/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-form";
    }
    @PostMapping("/products/save")
    public String saveProduct(Product product, RedirectAttributes ra) {
        prodService.save(product);
        ra.addFlashAttribute("message", "Le vêtement a bien été ajouté.");
        return "redirect:/products";
    }


    // EDIT ------------------------------
    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Product product = prodService.get(id);
            model.addAttribute("product", product);
            model.addAttribute("pageTitle", "Mise à jour du vêtement :");
            return "add-form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "Le vêtement a bien été modifié.");
            return "redirect:/products";

        }
    }

    // DELETE ------------------------------
    // Supprimer un produit
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes ra) {
        prodService.delete(id);
        return "redirect:/products";
    }
}
