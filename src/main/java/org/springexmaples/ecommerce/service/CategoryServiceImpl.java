package org.springexmaples.ecommerce.service;

import org.springexmaples.ecommerce.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService{


    private  List<Category> categories = new ArrayList<>();
    private Long nextId = 1L; // it should wrapper clasess otherwise it will give null

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {

        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categories.stream()
                .filter(ca ->ca.getCategoryId().equals(categoryId))
                .findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Response not found"));



       categories.remove(category);
       return "Category-ID "+categoryId+ " Is Removed";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categories.stream()
                .filter(ca ->ca.getCategoryId().equals(categoryId))
                .findFirst();

        if(optionalCategory.isPresent()){
            Category exstingCategory = optionalCategory.get();
            exstingCategory.setCategoryName(category.getCategoryName());
          return exstingCategory;
        }

        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Id not found");
        }

    }


}
