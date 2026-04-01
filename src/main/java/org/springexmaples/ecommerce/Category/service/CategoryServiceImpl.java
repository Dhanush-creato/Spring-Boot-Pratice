package org.springexmaples.ecommerce.Category.service;

import org.springexmaples.ecommerce.Category.Reposistory.CategoryReposistory;
import org.springexmaples.ecommerce.Category.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


//    private  List<Category> categories = new ArrayList<>();
    @Autowired
CategoryReposistory categoryReposistory;
   // it should wrapper clasess otherwise it will give null

    @Override
    public List<Category> getCategories() {
        return categoryReposistory.findAll();
    }

    @Override
    public void createCategory(Category category) {


        categoryReposistory.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {


        Category deleteCategory = categoryReposistory.findById(categoryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resourece not found"));

//        List<Category> categories = categoryReposistory.findAll();
//        Category category = categories.stream()
//                .filter(ca ->ca.getCategoryId().equals(categoryId))
//                .findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Response not found"));



       categoryReposistory.delete(deleteCategory);
       return "Category-ID "+categoryId+ " Is Removed";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
       categoryReposistory.findById(categoryId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Response not found"));  // it will find the id file and return error

        category.setCategoryId(categoryId); // what will give in update will set the given id and will update in category list
        return categoryReposistory.save(category);        // it will save and return

//        List<Category> categories = categoryReposistory.findAll();
//        Optional<Category> optionalCategory = categories.stream()
//                .filter(ca ->ca.getCategoryId().equals(categoryId))
//                .findFirst();
//
//        if(optionalCategory.isPresent()){
//            Category exstingCategory = optionalCategory.get();
//            exstingCategory.setCategoryName(category.getCategoryName());
//
//          return categoryReposistory.save(exstingCategory);
//        }
//
//        else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Id not found");
//        }

    }


}
