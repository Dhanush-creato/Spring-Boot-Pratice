package org.springexmaples.ecommerce.Category.model;

import jakarta.persistence.*;
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
    private String productName;
    private String image;
    private String description;
    private Integer productQuantity;
    private  Double price;
    private double discount;
    private Double specialPrice;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
   private Category category;

}
