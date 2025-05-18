package com.EWallet.Venmo.controller;


import com.EWallet.Venmo.exception_handling.ResourceNotFound;
import com.EWallet.Venmo.exception_handling.UnableToAdd;
import com.EWallet.Venmo.models.Account;
import com.EWallet.Venmo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/getAccount/{id}")
    public Account getAccountById(@PathVariable("id") int id){
        Account a = this.accountService.getAccount(id);
        if(a==null){
            logger.error("Resource not found");
            throw new ResourceNotFound("Unable to find");
        }
        logger.info("Account given");
        return a;
    }

    @PostMapping("/add")
    public Account addAccount(@RequestBody Account account){
        Account a = this.accountService.addAccount(account);
        if(a==null){
            logger.error("Unable to add");
            throw new UnableToAdd("Unable to add");
        }
        logger.info("Account added");
        return a;
    }

    @PutMapping("/update/{id}")
    public Account updateAccount(@PathVariable("id") int id , @RequestBody Account account) throws Exception {
        try{
            Account a = this.accountService.updateAccount(id,account);
            logger.info("Account updated");
            return a;
        }catch (Exception e){
            logger.info("Unable to update");
            throw new Exception("Unable to update");
        }
    }



}
