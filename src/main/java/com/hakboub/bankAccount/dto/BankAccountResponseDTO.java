package com.hakboub.bankAccount.dto;

import com.hakboub.bankAccount.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {

    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
