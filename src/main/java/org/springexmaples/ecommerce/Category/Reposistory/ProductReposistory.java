package org.springexmaples.ecommerce.Category.Reposistory;

import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReposistory extends JpaRepository<Product,Long> {
    Product findByProductName(String productName);



    List<Product> findByCategoryOrderByPriceAsc(Category category);


    List<Product> findByProductNameLikeIgnoreCase(String s);
}
