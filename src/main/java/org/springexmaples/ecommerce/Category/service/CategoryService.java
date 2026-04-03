package org.springexmaples.ecommerce.Category.service;

import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.payload.CategoryDTO;
import org.springexmaples.ecommerce.Category.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

     CategoryResponse getCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
