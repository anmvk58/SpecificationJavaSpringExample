package com.anmv.service;

import com.anmv.entity.Account;
import com.anmv.repository.IAccountRepository;
import com.anmv.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository repository;

    @Override
    public List<Account> getAllAccounts(String search, String departmentName) {
        Specification<Account> specification = AccountSpecification.buildWhere(search, departmentName);
        return repository.findAll(specification);
    }
}
