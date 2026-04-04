package org.springexmaples.ecommerce.Category.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRespose {
   protected String message;
    protected Boolean status;
}
