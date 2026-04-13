package org.springexmaples.ecommerce.Category.service;

import org.springexmaples.ecommerce.Category.payload.ProductDTO;
import org.springexmaples.ecommerce.Category.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface  ProductService {
    ProductDTO createProduct(Long categoryId, ProductDTO productDTO);


    ProductResponse getProductsByKeyword(String keyword, Integer pageNumber, Integer pageSize, String sortOrder, String sortBy);

    ProductDTO updateCategory(ProductDTO productDTO, Long productId);

    ProductDTO deleteService(Long productId);

    ProductDTO updateImageProduts(Long productId, MultipartFile image) throws IOException;

    ProductResponse getProducts(Integer pageSize, Integer pageNumber, String sortBy, String sortOrder);

    ProductResponse getProductsById(Long categoryId, Integer pageNumber, Integer pageSize, String sortOrder, String sortBy);
}
