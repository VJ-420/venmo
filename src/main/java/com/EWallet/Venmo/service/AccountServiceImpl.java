package com.EWallet.Venmo.service;

import com.EWallet.Venmo.models.Account;
import com.EWallet.Venmo.models.Wallet;
import com.EWallet.Venmo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private WalletService walletService;

    @Override
    public Account getAccount (int id){
        Account a = this.accountRepo.findById(id).orElse(null);
        return a;
    }

    @Override
    public Account addAccount(Account account){
        int id = account.getWallet().getWallet_id();
        Wallet wallet = this.walletService.getWalletById(id);
        account.setWallet(wallet);
        Account a = this.accountRepo.save(account);
        return a;
    }

    @Override
    public Account deleteAccount(int id){
        this.accountRepo.deleteById(id);
        return null;
    }

    @Override
    public Account updateAccount(int id , Account account){
        account.setAccount_id(id);
        Account a = this.accountRepo.save(account);
        return a;
    }
}
