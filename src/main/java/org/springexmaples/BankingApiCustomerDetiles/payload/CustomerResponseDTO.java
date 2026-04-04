package org.springexmaples.BankingApiCustomerDetiles.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {
   public List<CustomerDTO> bankCustomerDetails;
   public Integer pageSize;
   public  Integer pageNumber;
   public Long totalElements;
   public Integer totalPages;
   public Boolean isLast;
   public String sortBy;

}
