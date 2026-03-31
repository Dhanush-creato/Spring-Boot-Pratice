package org.springexmaples.BankingApiCustomerDetiles.Repo;

import org.springexmaples.BankingApiCustomerDetiles.Model.BankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCustomerEntity extends JpaRepository<BankCustomer,Long> {
}
