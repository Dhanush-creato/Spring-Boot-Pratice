package org.springexmaples.ecommerce.Category.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Product is required")
    @Size(min = 3 ,message = "Product Name Should be min 3 Charters")
    private String productName;
    private String image;
    @NotEmpty(message = "Product description is required")
    @Size(min = 5 ,message = "Product description Should be min 5 Charters")
    private String description;
    private Integer productQuantity;
    @NotNull(message = "Price Should not be Null")
    private  Double price;
    private double discount;
    private Double specialPrice;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
   private Category category;

}
