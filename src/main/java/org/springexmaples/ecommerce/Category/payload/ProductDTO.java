package org.springexmaples.ecommerce.Category.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String productName;
    private String description;
    private String image;
    private Integer productQuantity;
    private Double price;
    private double discount;
    private Double specialPrice;


}
