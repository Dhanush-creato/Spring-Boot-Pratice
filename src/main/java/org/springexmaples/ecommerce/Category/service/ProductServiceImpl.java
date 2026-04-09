package org.springexmaples.ecommerce.Category.service;

import org.modelmapper.ModelMapper;
import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springexmaples.ecommerce.Category.Reposistory.CategoryReposistory;
import org.springexmaples.ecommerce.Category.Reposistory.ProductReposistory;
import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.model.Product;
import org.springexmaples.ecommerce.Category.payload.CategoryResponse;
import org.springexmaples.ecommerce.Category.payload.ProductDTO;
import org.springexmaples.ecommerce.Category.payload.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    CategoryReposistory categoryReposistory;
    @Autowired
    ProductReposistory productReposistory;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDTO createProduct(Long categoryId, Product product) {
        Product savedproducts = productReposistory.findByProductName(product.getProductName());
        if (savedproducts != null) {
            throw new ApiExecption("The product " + product.getProductName() + " is Available ");
        }

        Category findCategory = categoryReposistory.findById(categoryId)
                    .orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));

        product.setCategory(findCategory);
        product.setImage("Default.img");
        double specialPrice = (product.getPrice() -( product.getDiscount()*0.01 )*product.getPrice());

        product.setSpecialPrice(specialPrice);
            Product product1 = productReposistory.save(product);
            ProductDTO productDTO = modelMapper.map(product1, ProductDTO.class);
            return productDTO;

    }

    @Override
    public ProductResponse getProducts() {
        List<Product>  productList = productReposistory.findAll();
        if(productList.isEmpty()){
            throw new ApiExecption("Products Are Empty");
        }

        List<ProductDTO> products = productList.stream()
                .map(product->modelMapper.map(product, ProductDTO.class)).toList();

        ProductResponse productResponses = new ProductResponse();
        productResponses.setProducts(products);

        return productResponses;


    }

    @Override
    public ProductResponse getProductsById(Long categoryId) {
       Category category = categoryReposistory.findById(categoryId)
               .orElseThrow(()->new ResourceNotFoundException("Products","Category Id",categoryId));


       List<Product> product = productReposistory.findByCategoryOrderByPriceAsc(category);
        List<ProductDTO> products = product.stream()
                .map(pro->modelMapper.map(pro, ProductDTO.class)).toList();

        ProductResponse productResponses = new ProductResponse();
        productResponses.setProducts(products);
        return productResponses;

    }

    @Override
    public ProductResponse getProductsByKeyword(String keyword) {



        List<Product> product = productReposistory.findByProductNameLikeIgnoreCase("%"+keyword+"%");
        if(product.isEmpty()){
            throw new ApiExecption(" No Products found With "+keyword);
        }
        List<ProductDTO> products = product.stream()
                .map(pro->modelMapper.map(pro, ProductDTO.class)).toList();

        ProductResponse productResponses = new ProductResponse();
        productResponses.setProducts(products);
        return productResponses;
    }
}