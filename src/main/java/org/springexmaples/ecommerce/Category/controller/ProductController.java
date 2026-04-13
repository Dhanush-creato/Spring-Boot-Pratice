package org.springexmaples.ecommerce.Category.controller;

import jakarta.validation.Valid;
import org.springexmaples.ecommerce.Category.config.AppConst;
import org.springexmaples.ecommerce.Category.payload.ProductDTO;
import org.springexmaples.ecommerce.Category.payload.ProductResponse;
import org.springexmaples.ecommerce.Category.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/admin/category/{category_id}/product")
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO , @PathVariable Long category_id){
       ProductDTO productDTOadeed =  productService.createProduct(category_id,productDTO);
        return new ResponseEntity<>(productDTOadeed, HttpStatus.CREATED);
    }

    @GetMapping("/admin/products")
    public ResponseEntity<ProductResponse> getCategory(@RequestParam(name ="pageSize", defaultValue = AppConst.PAGE_SIZE , required = false) Integer pageSize,
                                                       @RequestParam(name ="pageNumber", defaultValue = AppConst.PAGE_NUMBER , required = false) Integer pageNumber,
                                                       @RequestParam(name ="sortBy", defaultValue = AppConst.SORT_BY_PRODUCTS , required = false) String sortBy,
                                                       @RequestParam(name ="sortOrder", defaultValue = AppConst.SORT_ORDER , required = false) String sortOrder){
        ProductResponse productResponse = productService.getProducts(pageSize,pageNumber,sortBy,sortOrder);
        return  new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
    @GetMapping("/admin/category/{category_id}/products")
    public ResponseEntity<ProductResponse> getCategoryById(@PathVariable Long category_id,@RequestParam(name ="pageSize", defaultValue = AppConst.PAGE_SIZE , required = false) Integer pageSize,
                                                           @RequestParam(name ="pageNumber", defaultValue = AppConst.PAGE_NUMBER , required = false) Integer pageNumber,
                                                           @RequestParam(name ="sortBy", defaultValue = AppConst.SORT_BY_PRODUCTS , required = false) String sortBy,
                                                           @RequestParam(name ="sortOrder", defaultValue = AppConst.SORT_ORDER , required = false) String sortOrder){
        ProductResponse productResponsebyId = productService.getProductsById(category_id,pageNumber,pageSize,sortOrder,sortBy);
        return new ResponseEntity<>(productResponsebyId,HttpStatus.OK);
    }
    @GetMapping("/admin/products/{keyword}")
    public ResponseEntity<ProductResponse> getCategoryByKeyword(@PathVariable String keyword,@RequestParam(name ="pageSize", defaultValue = AppConst.PAGE_SIZE , required = false) Integer pageSize,
                                                                @RequestParam(name ="pageNumber", defaultValue = AppConst.PAGE_NUMBER , required = false) Integer pageNumber,
                                                                @RequestParam(name ="sortBy", defaultValue = AppConst.SORT_BY_PRODUCTS , required = false) String sortBy,
                                                                @RequestParam(name ="sortOrder", defaultValue = AppConst.SORT_ORDER , required = false) String sortOrder){
        ProductResponse productResponsebyId = productService.getProductsByKeyword(keyword,pageNumber,pageSize,sortOrder,sortBy);
        return new ResponseEntity<>(productResponsebyId,HttpStatus.OK);
    }

    @PutMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO productDTO, @PathVariable Long productId){
        ProductDTO updatedProduct = productService.updateCategory(productDTO,productId);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long productId){
        ProductDTO deleteProduct = productService.deleteService(productId);
        return new ResponseEntity<>(deleteProduct,HttpStatus.OK);
    }
    @PutMapping("/admin/products/{productId}/images")
    public ResponseEntity<ProductDTO> updateImageProduct(@PathVariable Long productId, @RequestParam("Image")MultipartFile image) throws IOException {
        ProductDTO updatedProduct = productService.updateImageProduts(productId,image);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }
}
