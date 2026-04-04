package org.springexmaples.BankingApiCustomerDetiles.Service;

import org.springexmaples.BankingApiCustomerDetiles.Model.BankCustomer;
import org.springexmaples.BankingApiCustomerDetiles.payload.CustomerDTO;
import org.springexmaples.BankingApiCustomerDetiles.payload.CustomerResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BankCustomerServiceImpl {
    public CustomerResponseDTO getCustomer(Integer pageNumber,Integer pageSize, String sortBy,String sortDirection);

    CustomerDTO postCustomer(CustomerDTO customerDTO);



    CustomerDTO deleteCustomer( Long id);

    CustomerDTO updateCustomer( CustomerDTO customerDTO,Long id);

    CustomerResponseDTO getCustomerWithId(Long id,Integer pageNumber,Integer pageSize, String sortBy,String sortDirection);
}
