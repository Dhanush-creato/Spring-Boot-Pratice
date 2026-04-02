package org.springexmaples.ecommerce.Category.Reposistory;

import org.springexmaples.ecommerce.Category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryReposistory extends JpaRepository<Category,Long> {


    Category findByCategoryName(String categoryName);
}
