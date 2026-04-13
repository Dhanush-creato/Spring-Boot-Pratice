package org.springexmaples.ecommerce.Category.service;

import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.model.Product;
import org.springexmaples.ecommerce.Category.payload.ProductDTO;
import org.springexmaples.ecommerce.Category.payload.ProductResponse;

public interface ProductService {
    ProductDTO createProduct(Long categoryId, ProductDTO productDTO);

    ProductResponse getProducts();

    ProductResponse getProductsById(Long categoryId);

    ProductResponse getProductsByKeyword(String keyword);

    ProductDTO updateCategory(ProductDTO productDTO, Long productId);

    ProductDTO deleteService(Long productId);
}
