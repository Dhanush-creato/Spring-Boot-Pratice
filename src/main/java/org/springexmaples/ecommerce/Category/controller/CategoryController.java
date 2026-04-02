package org.springexmaples.ecommerce.Category.controller;

import jakarta.validation.Valid;
import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController                   //contoller files is used fully for only api all the logic will be in servide layer add some bussiner logic in serivce now..
public class CategoryController {

    @Autowired
    private CategoryService categoryService;



@GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getCategories();
    return new ResponseEntity<>(categories,HttpStatus.OK);
    }


@PostMapping("/api/admin/categories")
    public ResponseEntity<String> createCategories(@Valid @RequestBody Category category){
   categoryService.createCategory(category);
    return  new ResponseEntity<>("Categories Added Successfully",HttpStatus.CREATED);
    //ResponseEntity.created("Categories Added Successfully") Second type of Enity usage anothe one is --- ResponseEntity.status(HttpStatus.ok).body(status) ---
    }

 @DeleteMapping("/api/admin/categories/{categoryId}")
 public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status, HttpStatus.OK);


 }


    @PutMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@Valid @RequestBody Category category, @PathVariable Long categoryId){

             categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Category id :"+categoryId +" is Updated", HttpStatus.OK);


    }
}
