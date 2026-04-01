package org.springexmaples.ecommerce.Category.service;

import org.springexmaples.ecommerce.Category.model.Category;

import java.util.List;

public interface CategoryService {

     List<Category> getCategories();
     void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
