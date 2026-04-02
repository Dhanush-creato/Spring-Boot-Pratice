package org.springexmaples.BankingApiCustomerDetiles.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BankCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long id;
    @NotEmpty(message = "First Name Should Contain")
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NotEmpty
    private String email;
    @Column(unique = true)
    @Size(min=10 ,message = "Should Contain 10 Numbers")
    private String phoneNumber;

//    public Long getId() {
//        return id;
//    }
//
//    public BankCustomer setId(Long id) {
//        this.id = id;
//        return this;
//    }

//    public Long getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public BankCustomer setPhoneNumber(Long phoneNumber) {
//        this.phoneNumber = phoneNumber;
//        return this;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public BankCustomer setEmail(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public BankCustomer setLastName(String lastName) {
//        this.lastName = lastName;
//        return this;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public BankCustomer setFirstName(String firstName) {
//        this.firstName = firstName;
//        return this;
//    }


//    public BankCustomer(Long id, String firstName, String lastName, String email, Long phoneNumber) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//    }

//    public BankCustomer() {
//    }
}
