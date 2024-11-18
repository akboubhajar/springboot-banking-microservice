package com.hakboub.bankAccount.web;

import com.hakboub.bankAccount.dto.BankAccountRequestDTO;
import com.hakboub.bankAccount.dto.BankAccountResponseDTO;
import com.hakboub.bankAccount.entities.BankAccount;
import com.hakboub.bankAccount.entities.Customer;
import com.hakboub.bankAccount.repositories.BankAccountRepository;
import com.hakboub.bankAccount.repositories.CustomerRepository;
import com.hakboub.bankAccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountList()
    {
        return bankAccountRepository.findAll();
    }


    @QueryMapping
    public BankAccount BankAccountById(@Argument String id)
    {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }


    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount)
    {
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
public BankAccountResponseDTO updateAccount(@Argument String id ,@Argument BankAccountRequestDTO bankAccount)
{
    return accountService.updateAccount(id,bankAccount);
    }




    @MutationMapping
    public  Boolean deleteAccount(@Argument String id )
    {
      accountService.deleteAccount(id);
      return true;
    }

    @QueryMapping
    public List<Customer> customers()
    {

   return customerRepository.findAll();

    }
}

