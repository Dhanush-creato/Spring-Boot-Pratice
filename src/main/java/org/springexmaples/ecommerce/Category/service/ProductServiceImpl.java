package org.springexmaples.ecommerce.Category.service;

import org.modelmapper.ModelMapper;
import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springexmaples.ecommerce.Category.Reposistory.CategoryReposistory;
import org.springexmaples.ecommerce.Category.Reposistory.ProductReposistory;
import org.springexmaples.ecommerce.Category.model.Category;
import org.springexmaples.ecommerce.Category.model.Product;
import org.springexmaples.ecommerce.Category.payload.ProductDTO;
import org.springexmaples.ecommerce.Category.payload.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    CategoryReposistory categoryReposistory;
    @Autowired
    ProductReposistory productReposistory;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
   private FileService fileService;

    @Value("${product.image}")
   private String path ;

    @Override
    public ProductDTO createProduct(Long categoryId, ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
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
            ProductDTO productDTOMain = modelMapper.map(product1, ProductDTO.class);
            return productDTOMain;

    }

    @Override
    public ProductResponse getProducts(Integer pageSize, Integer pageNumber, String sortBy, String sortOrder) {
        Sort sortbyAndOrder = sortOrder.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortbyAndOrder);
        Page<Product> pageProductList = productReposistory.findAll(pageable);



        List<Product>  productList = pageProductList.getContent();
        if(productList.isEmpty()){
            throw new ApiExecption("Products Are Empty");
        }

        List<ProductDTO> products = productList.stream()
                .map(product->modelMapper.map(product, ProductDTO.class)).toList();

        ProductResponse productResponses = new ProductResponse();
        productResponses.setProducts(products);
        productResponses.setPageNumber(pageProductList.getNumber());
        productResponses.setPageSize(pageProductList.getSize());
        productResponses.setTotalPages(pageProductList.getTotalPages());
        productResponses.setTotalElements(pageProductList.getTotalElements());
productResponses.setIsLast(pageProductList.isLast());
productResponses.setSortBy(String.valueOf(pageProductList.getSort()));
        return productResponses;


    }

    @Override
    public ProductResponse getProductsById(Long categoryId,Integer pageNumber, Integer pageSize, String sortOrder, String sortBy) {
        Category category = categoryReposistory.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Products","Category Id",categoryId));

        Sort sortbyandOrder = sortOrder.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortbyandOrder);
        Page<Product>  productPage = productReposistory.findByCategoryOrderByPriceAsc(category,pageable) ;


     if(productPage.isEmpty()){
    throw new ResourceNotFoundException("Products","Category Id",categoryId);
   }
        List<Product> product = productPage.getContent();
        List<ProductDTO> products = product.stream()
                .map(pro->modelMapper.map(pro, ProductDTO.class)).toList();

        ProductResponse productResponses = new ProductResponse();
        productResponses.setProducts(products);
        productResponses.setPageNumber(productPage.getNumber());
        productResponses.setPageSize(productPage.getSize());
        productResponses.setTotalElements(productPage.getTotalElements());
        productResponses.setTotalPages(productPage.getTotalPages());
        productResponses.setIsLast(productPage.isLast());
        productResponses.setSortBy(String.valueOf(productPage.getSort()));
        return productResponses;

    }

    @Override
    public ProductResponse getProductsByKeyword(String keyword, Integer pageNumber, Integer pageSize, String sortOrder, String sortBy) {

        Sort sortbyAndOrder = sortOrder.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortbyAndOrder);
        Page<Product> pageProductList = productReposistory.findByProductNameLikeIgnoreCase("%"+keyword+"%",pageable);



        List<Product>  productList = pageProductList.getContent();


        if(productList.isEmpty()){
            throw new ApiExecption(" No Products found With "+keyword);
        }
        List<ProductDTO> products = productList.stream()
                .map(pro->modelMapper.map(pro, ProductDTO.class)).toList();

        ProductResponse productResponses = new ProductResponse();
        productResponses.setProducts(products);
        productResponses.setPageNumber(pageProductList.getNumber());
        productResponses.setPageSize(pageProductList.getSize());
        productResponses.setTotalPages(pageProductList.getTotalPages());
        productResponses.setTotalElements(pageProductList.getTotalElements());
        productResponses.setIsLast(pageProductList.isLast());
        productResponses.setSortBy(String.valueOf(pageProductList.getSort()));

        return productResponses;
    }

    @Override
    public ProductDTO updateCategory(ProductDTO productDTO, Long productId) {
        Product product = modelMapper.map(productDTO,Product.class);
       productReposistory.findById(productId).orElseThrow(()->new ResourceNotFoundException("products","ProductID",productId));
        product.setId(productId);
        product.setImage("Default.img");
        double specialPrice = (product.getPrice() -( product.getDiscount()*0.01 )*product.getPrice());

        product.setSpecialPrice(specialPrice);
       Product updateProduct = productReposistory.save(product);
       ProductDTO productDTOs = modelMapper.map(updateProduct, ProductDTO.class);
        return productDTOs;
    }

    @Override
    public ProductDTO deleteService(Long productId) {
      Product deleted =  productReposistory.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product","Product Id",productId));
         productReposistory.delete(deleted);
         ProductDTO productDTO = modelMapper.map(deleted, ProductDTO.class);
        return productDTO;
    }

    @Override
    public ProductDTO updateImageProduts(Long productId, MultipartFile image) throws IOException {

        Product productsFromDb = productReposistory.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","Product Id",productId));

        String fileName = fileService.uploadImage(path,image);

        productsFromDb.setImage(fileName);

        Product savedProduct = productReposistory.save(productsFromDb);
        ProductDTO updatedImage = modelMapper.map(savedProduct,ProductDTO.class);
        return updatedImage;
    }


}
