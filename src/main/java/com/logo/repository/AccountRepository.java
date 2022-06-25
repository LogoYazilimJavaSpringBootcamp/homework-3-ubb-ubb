package com.logo.repository;

import com.logo.model.company.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByBankName(String bankName);
    List<Account> findByIban(String iban);
    Account findById(long id);
    Account deleteById(long id);


}
/**
    public static List<Account> accountList = new ArrayList<>();

    public Account save(Account account) {
        accountList.add(account);
        return account;
    }

    public List<Account> getAccount() {
        return accountList;
    }

 */