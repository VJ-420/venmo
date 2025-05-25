package com.EWallet.Venmo.service;

import com.EWallet.Venmo.exception_handling.InsufficientBalance;
import com.EWallet.Venmo.exception_handling.ResourceNotFound;
import com.EWallet.Venmo.exception_handling.TransactionFailed;
import com.EWallet.Venmo.exception_handling.WalletInactive;
import com.EWallet.Venmo.models.Transactions;
import com.EWallet.Venmo.models.Wallet;
import com.EWallet.Venmo.repository.TransactionRepo;
import com.EWallet.Venmo.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private WalletRepo walletRepo;

    @Override
    public void validateTransaction(Wallet wallet, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (!wallet.Is_active()) {
            throw new WalletInactive("Wallet is inactive");
        }
    }
    @Override
    public void recordTransaction(Wallet sender, Wallet receiver, double amount, String type, String status) {
        Transactions transactions = new Transactions();
        transactions.setDate(LocalDateTime.now());
        transactions.setAmount(amount);
        transactions.setStatus(status);
        transactions.setTransactionType(type);
        transactions.setSid(sender.getWallet_id());
        transactions.setRid(receiver.getWallet_id());
        this.transactionRepo.save(transactions);
    }

    @Transactional
    @Override
    public void transfer(int fromId , int toId , double amount){
        Wallet source = this.walletRepo.findById(fromId).orElseThrow(()
        -> new ResourceNotFound("Wallet not found"));
        validateTransaction(source,amount);

        Wallet destination = this.walletRepo.findById(toId).orElseThrow(()
        -> new ResourceNotFound("Wallet not found"));
        validateTransaction(destination,amount);

        if(source.getBalance()<amount){
            recordTransaction(source,destination,amount,"Transfer","Failed");
            throw new InsufficientBalance("Insufficient balance");
        }

        try{
            source.setBalance(source.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            walletRepo.save(source);
            walletRepo.save(destination);
            recordTransaction(source,destination,amount,"Transfer","Sucess");
        }catch (Exception e){
            recordTransaction(source,destination,amount,"Transfer","Failed");
            throw new TransactionFailed("Transaction failed");
        }
    }

    @Override
    public List<Transactions> getTransactionHistory(int walletId) {
        return transactionRepo.findByWallet_WalletId(walletId);
    }




}