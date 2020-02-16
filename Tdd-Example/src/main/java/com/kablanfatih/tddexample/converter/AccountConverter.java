package com.kablanfatih.tddexample.converter;

import com.kablanfatih.tddexample.dto.AccountDto;
import com.kablanfatih.tddexample.entitiy.Account;

import java.util.function.Function;

public class AccountConverter extends Converter<AccountDto, Account> {

    public AccountConverter() {
        super(AccountConverter::convertToEntity, AccountConverter::convertToDto);
    }

    private static AccountDto convertToDto(Account account) {
        return new AccountDto(account.getId(), account.getName(),
                account.getSurname(), account.getEmail(), account.getBirth_date(), account.getPassword(),
                account.getStatus(), account.getCreatedAt());
    }

    private static Account convertToEntity(AccountDto dto) {
        return new Account(dto.getId(), dto.getName(), dto.getSurname(), dto.getEmail(),
                dto.getBirth_date(), dto.getPassword(), dto.getStatus(), dto.getCreatedAt());
    }
}
