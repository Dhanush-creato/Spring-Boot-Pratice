package org.springexmaples.BankingApiCustomerDetiles.Service;

import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.BankingApiCustomerDetiles.Model.BankCustomer;
import org.springexmaples.BankingApiCustomerDetiles.Repo.BankCustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BankCustomerService implements BankCustomerServiceImpl {
    @Autowired
    BankCustomerEntity bankCustomerEntity;

     public List<BankCustomer> getCustomer(){
        return bankCustomerEntity.findAll();
    }

    @Override
    public void postCustomer(BankCustomer bankCustomer) {
        bankCustomerEntity.save(bankCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
       BankCustomer deleteElement = bankCustomerEntity.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Customers","Customer Id",id));
        bankCustomerEntity.delete(deleteElement);
    }

    @Override
    public void updateCustomer( BankCustomer bankCustomer,Long id) {
         bankCustomerEntity.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("CustomerName","Customer Id",id));

        bankCustomer.setId(id);
        bankCustomerEntity.save(bankCustomer);

    }

    @Override
    public Optional<BankCustomer> getCustomerWithId(Long id) {
        return bankCustomerEntity.findById(id);
    }
}
