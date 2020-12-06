package com.kablanfatih.tddexample.service.impl;

import com.kablanfatih.tddexample.converter.AccountConverter;
import com.kablanfatih.tddexample.dto.AccountDto;
import com.kablanfatih.tddexample.entitiy.Account;
import com.kablanfatih.tddexample.repository.AccountRepository;
import com.kablanfatih.tddexample.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountConverter converter;
    private final ModelMapper modelMapper;

    @Transactional
    public List<AccountDto> index() {
        List<Account> accounts = repository.findAll();
        return converter.createFromEntities(accounts);

    }

    @Transactional
    public AccountDto store(AccountDto accountDto) {
        Account account = new Account();
        account.setName(accountDto.getName());
        account.setSurname(accountDto.getSurname());
        account.setEmail(accountDto.getEmail());
        account.setBirth_date(accountDto.getBirth_date());
        account.setPassword(accountDto.getPassword());
        account.setStatus(accountDto.getStatus());
        final Account accountDb = repository.save(account);
        account.setId(accountDb.getId());

        return accountDto;
    }

    @Transactional
    public AccountDto show(String accountId) {
        Account account = repository.findById(accountId)
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(account,AccountDto.class);
    }

    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        System.out.println(id);
        Assert.notNull(id, "Id cannot be null");
        Optional<Account> account = repository.findById(id);
        Account accountToUpdate = account.map(it -> {
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            it.setEmail(accountDto.getEmail());
            it.setBirth_date(accountDto.getBirth_date());
            it.setPassword(accountDto.getPassword());
            it.setStatus(accountDto.getStatus());
            return it;
        }).orElseThrow(IllegalArgumentException::new);
        repository.save(accountToUpdate);
        return converter.convertFromEntity(accountToUpdate);
    }

    @Transactional
    public AccountDto delete(String accountId) {
        System.out.println(accountId);
        Account account = repository.findById(accountId)
                .orElseThrow(IllegalArgumentException::new);
        repository.deleteById(accountId);
        return converter.convertFromEntity(account);
    }
}
