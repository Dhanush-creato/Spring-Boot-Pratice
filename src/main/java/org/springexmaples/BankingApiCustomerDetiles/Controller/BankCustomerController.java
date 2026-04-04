package org.springexmaples.BankingApiCustomerDetiles.Controller;

import jakarta.validation.Valid;
import org.springexmaples.BankingApiCustomerDetiles.Model.BankCustomer;
import org.springexmaples.BankingApiCustomerDetiles.Service.BankCustomerService;

import org.springexmaples.BankingApiCustomerDetiles.config.DefaultValues;
import org.springexmaples.BankingApiCustomerDetiles.payload.CustomerDTO;
import org.springexmaples.BankingApiCustomerDetiles.payload.CustomerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class BankCustomerController {
    @Autowired
    BankCustomerService bankCustomerService;

    @GetMapping("/api/getCustomers")
    public ResponseEntity<CustomerResponseDTO> getCustomers(@RequestParam(defaultValue = DefaultValues.PAGE_NUMBER ,required = false) Integer pageNumber,
                                                            @RequestParam(defaultValue = DefaultValues.PAGE_SIZE ,required = false) Integer pageSize,
                                                            @RequestParam(defaultValue = DefaultValues.SORT_BY ,required = false) String sortBy,
                                                            @RequestParam(defaultValue = DefaultValues.SORT_DIRECTION ,required = false) String sortDirection){
       CustomerResponseDTO customer = bankCustomerService.getCustomer(pageNumber,pageSize,sortBy,sortDirection);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @GetMapping("/api/getCustomers/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomers(@PathVariable Long id,@RequestParam(defaultValue = DefaultValues.PAGE_NUMBER ,required = false) Integer pageNumber,
                                                            @RequestParam(defaultValue = DefaultValues.PAGE_SIZE ,required = false) Integer pageSize,
                                                            @RequestParam(defaultValue = DefaultValues.SORT_BY ,required = false) String sortBy,
                                                            @RequestParam(defaultValue = DefaultValues.SORT_DIRECTION ,required = false) String sortDirection){
        CustomerResponseDTO customer = bankCustomerService.getCustomerWithId(id,pageNumber,pageSize,sortBy,sortDirection);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @PostMapping("/api/postCustomers")
    public ResponseEntity<CustomerDTO> postCustomers(@Valid @RequestBody   CustomerDTO customerDTO){
        CustomerDTO savedData= bankCustomerService.postCustomer(customerDTO);
        return new ResponseEntity<>(savedData,HttpStatus.CREATED) ;
    }

    @DeleteMapping("/api/deleteCustomer/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Long id){

        CustomerDTO deletedCustomer= bankCustomerService.deleteCustomer(id);
            return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);


    }

    @PutMapping("/api/updateCustomer/{id}")
    public ResponseEntity<CustomerDTO> updateCustomers(@RequestBody CustomerDTO customerDTO ,@PathVariable Long id){

            CustomerDTO updatedCustomer =   bankCustomerService.updateCustomer(customerDTO, id);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.CREATED);

    }

}
