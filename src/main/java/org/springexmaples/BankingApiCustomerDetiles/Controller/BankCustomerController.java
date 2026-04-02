package org.springexmaples.BankingApiCustomerDetiles.Controller;

import jakarta.validation.Valid;
import org.springexmaples.BankingApiCustomerDetiles.Model.BankCustomer;
import org.springexmaples.BankingApiCustomerDetiles.Service.BankCustomerService;

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
    public ResponseEntity<List<BankCustomer>> getCustomers(){
        List<BankCustomer> customer = bankCustomerService.getCustomer();
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @GetMapping("/api/getCustomers/{id}")
    public ResponseEntity<Optional<BankCustomer>> getCustomers(@PathVariable Long id){
        Optional<BankCustomer> customer = bankCustomerService.getCustomerWithId(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @PostMapping("/api/postCustomers")
    public ResponseEntity<String> postCustomers(@Valid @RequestBody BankCustomer bankCustomer){
        bankCustomerService.postCustomer(bankCustomer);
        return new ResponseEntity<>("File is Updated",HttpStatus.CREATED) ;
    }

    @DeleteMapping("/api/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        try {
            bankCustomerService.deleteCustomer(id);
            return new ResponseEntity<>(" The file id with" + id + " is been Deleted", HttpStatus.OK);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PutMapping("/api/updateCustomer/{id}")
    public ResponseEntity<String> updateCustomers(@RequestBody BankCustomer bankCustomer ,@PathVariable Long id){
        try {
            bankCustomerService.updateCustomer(bankCustomer, id);
            return new ResponseEntity<>(" The file id with " + id + " is been updated", HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

}
