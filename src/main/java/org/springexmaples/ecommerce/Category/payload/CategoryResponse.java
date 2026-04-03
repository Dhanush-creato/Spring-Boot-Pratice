package org.springexmaples.ecommerce.Category.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {       //output to cilent
    private List<CategoryDTO> content;
}
