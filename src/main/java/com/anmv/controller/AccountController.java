package com.anmv.controller;

import org.modelmapper.ModelMapper;
import com.anmv.entity.Account;
import com.anmv.entity.AccountDTO;
import com.anmv.service.IAccountService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<AccountDTO> getAllAccounts(@RequestParam(value = "search", required = false) String search,
                                           @RequestParam(value = "department", required = false) String departmentName ){

        List<Account> accounts = service.getAllAccounts(search, departmentName);
        List<AccountDTO> accountDTOS = modelMapper.map(accounts, new TypeToken<List<AccountDTO>>(){
        }.getType());

        return accountDTOS;
    }

}
