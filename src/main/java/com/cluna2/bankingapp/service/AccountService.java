package com.cluna2.bankingapp.service;


import com.cluna2.bankingapp.models.Account;
import com.cluna2.bankingapp.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepo.findById(id);
    }

    public Account deposit(Long id, Double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepo.save(account);
    }

    public Account withdraw(Long id, Double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() - amount < 0) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepo.save(account);
    }


}
