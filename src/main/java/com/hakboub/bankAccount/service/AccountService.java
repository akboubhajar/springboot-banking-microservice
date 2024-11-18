package com.hakboub.bankAccount.service;

import com.hakboub.bankAccount.dto.BankAccountRequestDTO;
import com.hakboub.bankAccount.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO);

    void deleteAccount(String id);
}
