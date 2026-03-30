package org.springexmaples.ecommerce.Reposistory;

import org.springexmaples.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryReposistory extends JpaRepository<Category,Long> {
}
