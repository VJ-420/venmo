package com.EWallet.Venmo.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transaction_id;
    private LocalDateTime date;
    private double amount;
    private String transactionType; // DEPOSIT, WITHDRAWAL, TRANSFER
    private long senderWalletId;    // sid - for transfers
    private long receiverWalletId;  // rid - for transfers/deposits
    private String status;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Transactions(){
    }

    public Transactions(int transaction_id, LocalDateTime date, double amount, String transactionType, long sid, long rid, String status) {
        this.transaction_id = transaction_id;
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
        this.senderWalletId = sid;
        this.receiverWalletId = rid;
        this.status = status;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getSid() {
        return senderWalletId;
    }

    public void setSid(long sid) {
        this.senderWalletId = sid;
    }

    public long getRid() {
        return receiverWalletId;
    }

    public void setRid(long rid) {
        this.receiverWalletId = rid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
