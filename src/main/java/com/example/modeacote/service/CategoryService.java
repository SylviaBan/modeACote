package com.example.modeacote.service;

import com.example.modeacote.model.Category;
import com.example.modeacote.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository catRepo;

    // CREATE
    public Category addCat(Category category) {
        return catRepo.save(new Category(category.getName()));
    }
    // FIND
    public List<Category> findAllCat() {;
        return catRepo.findAll();
    }
    public Optional<Category> findCatById(Long id) {
        return catRepo.findById(id);
    }
    // UPDATE
    public Category updateCat(Long id, Category category) {
        if (existsById(id)) {

            Category existingCat = catRepo.findById(id).orElse(null);

            if (existingCat != null) {
                existingCat.setName(category.getName());
                Category updatedTutorial = catRepo.save(existingCat);
            }
        }
        return null;
    }
    public boolean existsById(Long id) {
        catRepo.existsById(id);
        return false;
    }

    // DELETE
    public void deleteCatById(Long id) {
        catRepo.deleteById(id);
    }
    public void deleteAllCat() {
        catRepo.deleteAll();
    }
}


