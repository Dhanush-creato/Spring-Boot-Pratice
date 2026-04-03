package org.springexmaples.ecommerce.Category.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {   //request fro cilent

    private Long categoryId;
    private String categoryName;
}
