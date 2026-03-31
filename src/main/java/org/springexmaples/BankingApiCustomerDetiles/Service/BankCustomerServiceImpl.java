package org.springexmaples.BankingApiCustomerDetiles.Service;

import org.springexmaples.BankingApiCustomerDetiles.Model.BankCustomer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BankCustomerServiceImpl {
    public List<BankCustomer> getCustomer();

    void postCustomer(BankCustomer bankCustomer);



    void deleteCustomer( Long id);

    void updateCustomer( BankCustomer bankCustomer,Long id);

    Optional<BankCustomer> getCustomerWithId(Long id);
}
