package com.hakboub.bankAccount;

import com.hakboub.bankAccount.entities.BankAccount;
import com.hakboub.bankAccount.entities.Customer;
import com.hakboub.bankAccount.enums.AccountType;
import com.hakboub.bankAccount.repositories.BankAccountRepository;
import com.hakboub.bankAccount.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean

	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository)
	{
         return args->
		 {

			 Stream.of("Sara","Hajar","Aya","Meryam").forEach(
					 c->{
						 Customer customer = Customer.builder()
								 .name(c)
								 .build();
						 customerRepository.save(customer);
					 }
			 );

			 customerRepository.findAll().forEach(customer ->
			 {
				 for (int i=0 ;i<10;i++)
				 {
					 BankAccount bankAccout =BankAccount.builder()
							 .id(UUID.randomUUID().toString())
							 .type(Math.random()>0.5? AccountType.Current_ACCOUNT:AccountType.SAVING_ACCOUNT)
							 .balance(10000*Math.random()*70000)
							 .createAt(new Date())
							 .currency("MAD")
							 .customer(customer)
							 .build();
					 bankAccountRepository.save(bankAccout);

				 }




			 });

		 };
	}
}
