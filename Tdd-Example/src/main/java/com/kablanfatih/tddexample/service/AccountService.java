package com.kablanfatih.tddexample.service;

import com.kablanfatih.tddexample.dto.AccountDto;

import javax.persistence.Converter;
import java.util.List;

public interface AccountService {

    List<AccountDto> index();

    AccountDto store(AccountDto AccountDto);

    AccountDto show(String accountId);

    AccountDto update(String id, AccountDto AccountDto);

    AccountDto delete(String accountId);

}
