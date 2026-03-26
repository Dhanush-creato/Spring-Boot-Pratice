package org.springexmaples.ecommerce.service;

import org.springexmaples.ecommerce.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


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

        category.setCategoryId((nextId++));
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


}
