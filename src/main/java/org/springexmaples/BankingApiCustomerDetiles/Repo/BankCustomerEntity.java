package org.springexmaples.BankingApiCustomerDetiles.Repo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springexmaples.BankingApiCustomerDetiles.Model.BankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCustomerEntity extends JpaRepository<BankCustomer,Long> {
    BankCustomer findByEmail(@NotEmpty String email);

    BankCustomer findByPhoneNumber(@Size(min=10 ,message = "Should Contain 10 Numbers") String phoneNumber);
}
