package com.mybank.demo.controller;

import com.mybank.demo.entity.Account;
import com.mybank.demo.exception.ResourceNotFoundException;
import com.mybank.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    //create get all accounts api
@GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    //create employee

    @PostMapping("/accounts")
    public Account createAccount(@Validated @RequestBody Account account){
    return accountRepository.save(account);
    }

    //get account by id
    @GetMapping ("accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "id")int accountId) throws ResourceNotFoundException {
     Account account= accountRepository.findById(accountId).orElseThrow(() ->new ResourceNotFoundException("Account not found for this id ::" + accountId));
     return ResponseEntity.ok().body(account);
    }
    //update acount
    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable(value = "id")int accountId, @RequestBody Account accountDetails) throws ResourceNotFoundException {
        Account account= accountRepository.findById(accountId).orElseThrow(() ->new ResourceNotFoundException("Account not found for this id ::" + accountId));
        account.setAccountName(accountDetails.getAccountName());
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setAccountBalance(accountDetails.getAccountBalance());
        accountRepository.save(account);
        return ResponseEntity.ok().body(account);

    }
    //delete account by id

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity deleteAccount(@PathVariable(value = "id")int accountId) throws ResourceNotFoundException {
    accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found for this id ::" + accountId));
    accountRepository.deleteById(accountId);
    return ResponseEntity.ok().build();
    }
}
