package org.springexmaples.ecommerce.Category.controller;

import jakarta.validation.Valid;
import org.springexmaples.ecommerce.Category.config.AppConst;
import org.springexmaples.ecommerce.Category.payload.CategoryDTO;
import org.springexmaples.ecommerce.Category.payload.CategoryResponse;
import org.springexmaples.ecommerce.Category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                   //contoller files is used fully for only api all the logic will be in servide layer add some bussiner logic in serivce now..
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

@GetMapping("/api/public/categories")
    public ResponseEntity<CategoryResponse> getCategories(
            @RequestParam(name="pageNumber",defaultValue = AppConst.PAGE_NUMBER ,required = false) Integer pageNumber,  //first step to pagination we need parameter's
            @RequestParam(name="pageSize" ,defaultValue = AppConst.PAGE_SIZE,required = false) Integer pageSize
) {
        CategoryResponse categories = categoryService.getCategories(pageNumber,pageSize);
    return new ResponseEntity<>(categories,HttpStatus.OK);
    } //done dto


@PostMapping("/api/admin/categories")
    public ResponseEntity<CategoryDTO> createCategories(@Valid @RequestBody CategoryDTO categoryDTO){
   CategoryDTO savedCategoryDto = categoryService.createCategory(categoryDTO);
    return  new ResponseEntity<>(savedCategoryDto,HttpStatus.CREATED);
    //ResponseEntity.created("Categories Added Successfully") Second type of Enity usage anothe one is --- ResponseEntity.status(HttpStatus.ok).body(status) ---
    }

 @DeleteMapping("/api/admin/categories/{categoryId}")
 public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId){
        CategoryDTO deletedObjectByDTO = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(deletedObjectByDTO, HttpStatus.OK);


 }


    @PutMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId){

         CategoryDTO updatedDTO = categoryService.updateCategory(categoryDTO,categoryId);
            return new ResponseEntity<>( updatedDTO, HttpStatus.OK);


    }
}
