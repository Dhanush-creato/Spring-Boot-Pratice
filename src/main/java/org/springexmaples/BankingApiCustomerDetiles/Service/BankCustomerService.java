package org.springexmaples.BankingApiCustomerDetiles.Service;

import org.modelmapper.ModelMapper;
import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.BankingApiCustomerDetiles.Model.BankCustomer;
import org.springexmaples.BankingApiCustomerDetiles.Repo.BankCustomerEntity;
import org.springexmaples.BankingApiCustomerDetiles.payload.CustomerDTO;
import org.springexmaples.BankingApiCustomerDetiles.payload.CustomerResponseDTO;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BankCustomerService implements BankCustomerServiceImpl {
    @Autowired
    BankCustomerEntity bankCustomerEntity;

      @Autowired
      ModelMapper modelMapper;
     public CustomerResponseDTO getCustomer(Integer pageNumber,Integer pageSize, String sortBy,String sortDirection){
         Sort sortByAndDirectin = sortDirection.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending()
                 :Sort.by(sortBy).descending();
         Pageable pageable = PageRequest.of(pageNumber,pageSize,sortByAndDirectin);
         Page<BankCustomer>  pageList=  bankCustomerEntity.findAll(pageable);

         List<BankCustomer> allBankCustomer = pageList.getContent();
         if(allBankCustomer.isEmpty()){
             throw new ApiExecption("Bank Customer Detailes is Empty");
         }

         List<CustomerDTO> customerDTOList = allBankCustomer.stream().map(bankCustomer->modelMapper.map(bankCustomer, CustomerDTO.class))
                 .toList();
         CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
         customerResponseDTO.setBankCustomerDetails(customerDTOList);
         customerResponseDTO.setPageNumber(pageList.getNumber());
         customerResponseDTO.setPageSize(pageList.getSize());
         customerResponseDTO.setTotalElements(pageList.getTotalElements());
         customerResponseDTO.setTotalPages(pageList.getTotalPages());
         customerResponseDTO.setIsLast(pageList.isLast());
         customerResponseDTO.setSortBy(String.valueOf(pageList.getSort()));



         return customerResponseDTO;
    }

    @Override
    public CustomerDTO postCustomer(CustomerDTO customerDTO) {
         BankCustomer bankCustomer /*DTOtobankCustomer*/ = modelMapper.map(customerDTO, BankCustomer.class);
        BankCustomer bankCustomerEmail = bankCustomerEntity.findByEmail(bankCustomer.getEmail());
        BankCustomer bankCustomerPhone = bankCustomerEntity.findByPhoneNumber(bankCustomer.getPhoneNumber());

        if(bankCustomerEmail !=null){
            throw new ApiExecption("The given Email "+bankCustomer.getEmail()+" is Available");
        }
       else if(bankCustomerPhone != null){
            throw new ApiExecption("The given Phone Number "+bankCustomer.getPhoneNumber()+" is Available");
        }
        BankCustomer savedCustomers = bankCustomerEntity.save(bankCustomer);
       CustomerDTO bankToDTO = modelMapper.map(savedCustomers,CustomerDTO.class);

           return bankToDTO;
    }

    @Override
    public CustomerDTO deleteCustomer(Long id) {
       BankCustomer deleteElement = bankCustomerEntity.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Customers","Customer Id",id));
       bankCustomerEntity.delete(deleteElement);
       CustomerDTO deletedCustomer = modelMapper.map(deleteElement,CustomerDTO.class);
       return deletedCustomer;
    }

    @Override
    public CustomerDTO updateCustomer(  CustomerDTO customerDTO,Long id) {
        BankCustomer bankCustomer /*DTOtobankCustomer*/ = modelMapper.map(customerDTO, BankCustomer.class);
         bankCustomerEntity.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("CustomerName","Customer Id",id));

        bankCustomer.setId(id);
        BankCustomer updatedCustomers =bankCustomerEntity.save(bankCustomer);
        CustomerDTO result = modelMapper.map(updatedCustomers, CustomerDTO.class);
        return result;

    }

    @Override
    public CustomerResponseDTO getCustomerWithId(Long id,Integer pageNumber,Integer pageSize, String sortBy,String sortDirection) {
        Sort sortByAndDirectin = sortDirection.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortByAndDirectin);
        Page<BankCustomer>  pageList=  bankCustomerEntity.findAll(pageable);
         Optional<BankCustomer> bankCustomerById = bankCustomerEntity.findById(id);

         if(bankCustomerById.isEmpty()){
             throw new ApiExecption("Customer Details is Not Found in ID:"+id);
         }
         List<CustomerDTO> customerDTOList = bankCustomerById.stream().map(customer->modelMapper.map(customer, CustomerDTO.class)).toList();
         CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setPageNumber(pageList.getNumber());
        customerResponseDTO.setPageSize(pageList.getSize());
        customerResponseDTO.setTotalElements(pageList.getTotalElements());
        customerResponseDTO.setTotalPages(pageList.getTotalPages());
        customerResponseDTO.setIsLast(pageList.isLast());
        customerResponseDTO.setSortBy(String.valueOf(pageList.getSort()));

         customerResponseDTO.setBankCustomerDetails(customerDTOList);
        return customerResponseDTO;
    }
}
