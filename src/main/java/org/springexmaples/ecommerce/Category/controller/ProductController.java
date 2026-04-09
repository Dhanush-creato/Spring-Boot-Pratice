package org.springexmaples.ecommerce.Category.controller;

import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.model.Product;
import org.springexmaples.ecommerce.Category.payload.ProductDTO;
import org.springexmaples.ecommerce.Category.payload.ProductResponse;
import org.springexmaples.ecommerce.Category.service.ProductService;
import org.springexmaples.ecommerce.Category.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/admin/category/{category_id}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product , @PathVariable Long category_id){
       ProductDTO productDTO =  productService.createProduct(category_id,product);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/admin/products")
    public ResponseEntity<ProductResponse> getCategory(){
        ProductResponse productResponse = productService.getProducts();
        return  new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
    @GetMapping("/admin/category/{category_id}/products")
    public ResponseEntity<ProductResponse> getCategoryById(@PathVariable Long category_id){
        ProductResponse productResponsebyId = productService.getProductsById(category_id);
        return new ResponseEntity<>(productResponsebyId,HttpStatus.OK);
    }
    @GetMapping("/admin/products/{keyword}")
    public ResponseEntity<ProductResponse> getCategoryById(@PathVariable String keyword){
        ProductResponse productResponsebyId = productService.getProductsByKeyword(keyword);
        return new ResponseEntity<>(productResponsebyId,HttpStatus.OK);
    }
}
