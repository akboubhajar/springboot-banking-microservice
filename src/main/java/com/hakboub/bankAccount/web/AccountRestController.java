package com.hakboub.bankAccount.web;

import com.hakboub.bankAccount.dto.BankAccountRequestDTO;
import com.hakboub.bankAccount.dto.BankAccountResponseDTO;
import com.hakboub.bankAccount.entities.BankAccount;
import com.hakboub.bankAccount.mappers.AccountMapper;
import com.hakboub.bankAccount.repositories.BankAccountRepository;
import com.hakboub.bankAccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/")
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/BankAccounts/")
    public List<BankAccount> BankAccounts()
    {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/BankAccounts/{id}")
    public BankAccount  BankAccounts(@PathVariable String id)
    {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccount")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO)
    {
        return accountService.addAccount(requestDTO);
    }


    @PutMapping("/bankAccounts/{id}")
    public  BankAccount update(@PathVariable String id,@RequestBody BankAccount BankAccount)
    {
        BankAccount account=bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        if (BankAccount.getBalance()!= null)account.setBalance(BankAccount.getBalance());
        if (BankAccount.getCreateAt()!= null)account.setCreateAt(new Date());
        if (BankAccount.getCreateAt()!= null)account.setType(BankAccount.getType());
        if (BankAccount.getCurrency()!= null)account.setCurrency(BankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id)
    {

         bankAccountRepository.deleteById(id);
    }
}
