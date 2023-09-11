package com.example.modeacote.service;

import com.example.modeacote.model.Product;
import com.example.modeacote.repository.ProductRepository;
import com.example.modeacote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository prodRepo;

    // CREATE

    public Product addProd(Product product) {
        return prodRepo.save(new Product());
    }

    // FIND
    public List<Product> listAll() {;
        return prodRepo.findAll();
    }
    public Optional<Product> findProdById(Long id) {
        return prodRepo.findById(id);
    }
    // UPDATE
    public Product updateProd(Long id, Product product) {
        if (existsById(id)) {

            Product existingProd = prodRepo.findById(id).orElse(null);

            if (existingProd != null) {
                existingProd.setName(product.getName());
                Product updatedTutorial = prodRepo.save(existingProd);
            }
        }
        return null;
    }
    public boolean existsById(Long id) {
        prodRepo.existsById(id);
        return false;
    }

    // DELETE
    public void delete(Long id) {
        prodRepo.deleteById(id);
    }
    public void deleteAllProd() {
        prodRepo.deleteAll();
    }

    public void save(Product product) {
        prodRepo.save(product);
    }

    public Product get(Long id) throws UserNotFoundException {
        Optional<Product> result = prodRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Product with the ID not found" +id);
    }
}
