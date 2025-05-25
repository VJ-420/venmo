package com.EWallet.Venmo.service;

import com.EWallet.Venmo.models.Transactions;
import com.EWallet.Venmo.models.Wallet;

import java.util.List;

public interface TransactionService  {

    public void validateTransaction(Wallet wallet, double amount);
    public void recordTransaction(Wallet sender, Wallet receiver, double amount, String type, String status);
    public void transfer(int fromId , int toId , double amount);
    public List<Transactions> getTransactionHistory(int walletId);


}
