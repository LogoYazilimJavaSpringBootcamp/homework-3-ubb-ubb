package com.logo.service;

import com.logo.model.company.Account;
import com.logo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account account) {

        accountRepository.save(account);
        return account;
    }

    public Account findById(long id) {
        Account account = accountRepository.findById(id);
        return account;
    }

    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account updateAccount(long id, Account account) {

        Account accountToUpdate = accountRepository.findById(id);

        if (account.getBankName() != null) {
            accountToUpdate.setBankName(account.getBankName());
        }

        if (account.getIban() != null) {
            accountToUpdate.setIban(account.getIban());
        }
        if (account.getCurrency() != null) {
            accountToUpdate.setCurrency(account.getCurrency());
        }
        if (account.getCustomer() != null) {
            accountToUpdate.setCustomer(account.getCustomer());
        }
        if (account.getBalance() != null) {
            accountToUpdate.setBalance(account.getBalance());
        }

        accountRepository.save(accountToUpdate);
        return accountToUpdate;

    }

    public Account deleteAccount(long id) {
        return accountRepository.deleteById(id);
    }

}
