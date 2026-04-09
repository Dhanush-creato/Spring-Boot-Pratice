package org.springexmaples.ecommerce.Category.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotBlank(message = "Category Name should not be Blank")
    @Size(min = 5,message = "Category Name Should be min 5 Charters")

    private  String categoryName ;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
