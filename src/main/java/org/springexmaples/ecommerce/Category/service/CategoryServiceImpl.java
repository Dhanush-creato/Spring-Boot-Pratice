package org.springexmaples.ecommerce.Category.service;

import org.modelmapper.ModelMapper;
import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springexmaples.ecommerce.Category.Reposistory.CategoryReposistory;
import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.payload.CategoryDTO;
import org.springexmaples.ecommerce.Category.payload.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


//    private  List<Category> categories = new ArrayList<>();
    @Autowired
CategoryReposistory categoryReposistory;
   // it should wrapper clasess otherwise it will give null
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getCategories(Integer pageNumber ,Integer pageSize) {
        List<Category> categories = categoryReposistory.findAll();
        if(categories.isEmpty()){
            throw new ApiExecption("There is not Category's present");
        }
        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                        .toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse ;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
 Category category = modelMapper.map(categoryDTO, Category.class); // to convert from Dto to category  and assign to category
        Category savedCategory = categoryReposistory.findByCategoryName(category.getCategoryName());
        if(savedCategory !=null){
            throw new ApiExecption("Category with name " +category.getCategoryName()+" is found");
        }


        Category savedCategorieToConvert = categoryReposistory.save(category);
        CategoryDTO savedCategoryDto = modelMapper.map(savedCategorieToConvert, CategoryDTO.class);
        return  savedCategoryDto;
    }

    @Override
    public  CategoryDTO deleteCategory(Long categoryId) {


        Category deleteCategory = categoryReposistory.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));


        categoryReposistory.delete(deleteCategory);
        CategoryDTO categoryDto = modelMapper.map(deleteCategory, CategoryDTO.class);


       return categoryDto;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
       categoryReposistory.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));  // it will find the id file and return error


        Category category = modelMapper.map(categoryDTO, Category.class);

        category.setCategoryId(categoryId);// what will give in update will set the given id and will update in category list

        Category updatedCategory = categoryReposistory.save(category);

         CategoryDTO updatedCategoryDTO = modelMapper.map(updatedCategory, CategoryDTO.class);

        return updatedCategoryDTO;      // it will save and return



    }


}
