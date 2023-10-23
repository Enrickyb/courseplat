package com.courseplat.courseplat.controllers.TransactionControllers;

import com.courseplat.courseplat.domain.transactions.Category.Category;
import com.courseplat.courseplat.domain.transactions.Category.CategoryDTO;
import com.courseplat.courseplat.domain.transactions.Category.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transaction/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryDTO category) {
        try{
            Category cat = categoryRepository.findByName(category.name());
            if(cat != null){
                return ResponseEntity.badRequest().body("Category already exists");
            }
           Category exp = categoryRepository.save(new Category(category.name()));
            return ResponseEntity.ok().body("Category created successfully" + exp.toString());


        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getCategories() {
        try{
            return ResponseEntity.ok().body(categoryRepository.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


}
