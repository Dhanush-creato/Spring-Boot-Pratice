package org.springexmaples.ecommerce.Category.Reposistory;

import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReposistory extends JpaRepository<Product,Long> {
    Product findByProductName(String productName);






    Page<Product> findByProductNameLikeIgnoreCase(String keyword, Pageable pageable);

    Page<Product> findByCategoryOrderByPriceAsc(Category category, Pageable pageable);
}
