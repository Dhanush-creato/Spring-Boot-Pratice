package org.springexmaples.ecommerce.controller;

import org.jspecify.annotations.Nullable;
import org.springexmaples.ecommerce.model.Category;
import org.springexmaples.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController                   //contoller files is used fully for only api all the logic will be in servide layer add some bussiner logic in serivce now..
public class CategoryController {

    @Autowired
    private CategoryService categoryService;



@GetMapping("/api/public/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }


@PostMapping("/api/admin/categories")
    public String createCategories(@RequestBody Category category){
   categoryService.createCategory(category);
    return "Categories Added Successfully";
    }

 @DeleteMapping("/api/admin/categories/{categoryId}")
 public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
    try {
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    } catch (ResponseStatusException e) {
        return new ResponseEntity<>(e.getReason(),e.getStatusCode());
    }

 }
}
