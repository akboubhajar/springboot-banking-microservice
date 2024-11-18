package com.hakboub.bankAccount.service;

import com.hakboub.bankAccount.dto.BankAccountRequestDTO;
import com.hakboub.bankAccount.dto.BankAccountResponseDTO;
import com.hakboub.bankAccount.entities.BankAccount;
import com.hakboub.bankAccount.mappers.AccountMapper;
import com.hakboub.bankAccount.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {


    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {

        BankAccount bankAcc=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDTO.getType())
                .balance(bankAccountDTO.getBalance())
                .createAt(new Date())
                .currency(bankAccountDTO.getCurrency())
                .build();

        BankAccount saveBankAccount =bankAccountRepository.save(bankAcc);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id ,BankAccountRequestDTO bankAccountDTO)
    {
        BankAccount bankAcc=BankAccount.builder()
                .id(id)
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount =bankAccountRepository.save(bankAcc);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public void deleteAccount(String id )
    {
        bankAccountRepository.deleteById(id);
    }
}
