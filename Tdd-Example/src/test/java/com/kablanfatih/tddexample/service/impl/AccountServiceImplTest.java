package com.kablanfatih.tddexample.service.impl;

import com.kablanfatih.tddexample.converter.AccountConverter;
import com.kablanfatih.tddexample.dto.AccountDto;
import com.kablanfatih.tddexample.entitiy.Account;
import com.kablanfatih.tddexample.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static com.kablanfatih.tddexample.entitiy.AccountStatus.IN_PROGRESS;
import static com.kablanfatih.tddexample.entitiy.AccountStatus.OPEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountService;

    @Mock
    AccountRepository accountRepository;

    @Mock
    Account account;

    String randomUUID;

    @Mock
    AccountConverter converter;

    Date date;


    @BeforeEach
    public void setup() {
        randomUUID = String.valueOf(UUID.randomUUID());
        date = new Date();
        account = new Account();
        account.setId(randomUUID);
        account.setName("account");
        account.setEmail("email@email");
        account.setSurname("test");
        account.setEmail("test@email");
        account.setBirth_date(date);
        account.setStatus(IN_PROGRESS);
        accountRepository.save(account);
    }

    @Test
    void index() {

        when(accountRepository.findAll()).thenReturn(Collections.singletonList(account));
        List<AccountDto> result = (List<AccountDto>) accountService.index();

        assertEquals(account.getEmail(), result.get(0).getEmail());
    }

    @Test
    void store() {
        Date date = new Date();
        Account accountMock = mock(Account.class);
        AccountDto accountDto = new AccountDto();
        accountDto.setId(randomUUID);
        accountDto.setName("Test-Name");
        accountDto.setSurname("Test-Lastname");
        accountDto.setEmail("Test-Email");
        accountDto.setBirth_date(date);
        accountDto.setPassword("Test-Email");
        accountDto.setStatus(OPEN);

        when(accountMock.getId()).thenReturn(String.valueOf(randomUUID));
        when(accountRepository.save(ArgumentMatchers.any(Account.class))).thenReturn(accountMock);
        AccountDto result = accountService.store(accountDto);
        assertEquals(result.getName(), accountDto.getName());
        assertEquals(result.getId(), String.valueOf(randomUUID));

    }

    @Test
    void show() {

        Account account = new Account();
        account.setId(randomUUID);
        account.setName("Test-Name");
        account.setSurname("Test-Lastname");
        account.setEmail("Test-Email");
        account.setBirth_date(date);
        account.setPassword("Test-Email");
        account.setStatus(OPEN);
        when(accountRepository.findById(randomUUID)).thenReturn(Optional.of(account));
        AccountDto result = accountService.show(randomUUID);



        assertEquals(result.getId(), randomUUID);
        assertEquals(result.getEmail(), account.getEmail());
    }

    @Test
    void update() {
        AccountDto accountDto = new AccountDto();
        accountDto.setName("Test-Name");
        accountDto.setSurname("Test-Lastname");
        String randomUUID = String.valueOf(UUID.randomUUID());

        when(accountRepository.findById(randomUUID)).thenReturn(Optional.of(account));
        AccountDto result = accountService.update(randomUUID, accountDto);

        assertEquals(result.getId(), accountDto.getId());
        assertEquals(result.getName(), accountDto.getName());
    }

    @Test
    void delete() {
        Account account = new Account();
        account.setId(randomUUID);
        account.setName("Test-Name");
        account.setSurname("Test-Lastname");
        account.setEmail("Test-Email");
        account.setBirth_date(date);
        account.setPassword("Test-Email");
        account.setStatus(OPEN);
        when(accountRepository.findById(randomUUID)).thenReturn(Optional.of(account));
        AccountDto result = accountService.delete(randomUUID);

        assertEquals(result.getEmail(), account.getEmail());

    }
}