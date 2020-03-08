package com.kablanfatih.tddexample.controller;

import com.kablanfatih.tddexample.dto.AccountDto;
import com.kablanfatih.tddexample.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountDto> store(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(service.store(accountDto));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> index(){
       return ResponseEntity.ok(service.index());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> show(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @RequestBody AccountDto accountDto){
        return ResponseEntity.ok(service.update(id,accountDto));
    }

    @DeleteMapping("/{id}")
    public AccountDto delete(@PathVariable("id") String id) {
       return service.delete(id);
    }

}
