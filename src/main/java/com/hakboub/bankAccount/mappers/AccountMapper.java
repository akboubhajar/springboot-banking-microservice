package com.hakboub.bankAccount.mappers;

import com.hakboub.bankAccount.dto.BankAccountResponseDTO;
import com.hakboub.bankAccount.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component //ou @Service
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount)
    {
        BankAccountResponseDTO bankAccountResponseDTO =new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
