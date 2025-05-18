package com.EWallet.Venmo.service;
import com.EWallet.Venmo.models.Account;

public interface AccountService {

    public Account addAccount(Account account);
    public Account deleteAccount(int id);
    public Account updateAccount(int id , Account account);
    public Account getAccount (int id);
}
