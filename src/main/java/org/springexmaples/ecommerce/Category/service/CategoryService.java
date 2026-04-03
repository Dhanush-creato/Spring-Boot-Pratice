package org.springexmaples.ecommerce.Category.service;

import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.payload.CategoryDTO;
import org.springexmaples.ecommerce.Category.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

     CategoryResponse getCategories(Integer pageNumber,Integer pageSize);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
