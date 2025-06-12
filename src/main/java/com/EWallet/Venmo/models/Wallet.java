package com.EWallet.Venmo.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wallet_id")
    private int walletId;
    private double balance;
    private boolean isActive;
    @OneToOne(mappedBy = "wallet")
    private User user;
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Account> accounts;
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<Transactions> transactions;

    public Wallet(){

    }

    public Wallet(int wallet_id, double balance, boolean is_active) {
        this.walletId = wallet_id;
        this.balance = balance;
        this.isActive = is_active;
    }

    public int getWallet_id() {
        return walletId;
    }

    public void setWallet_id(int wallet_id) {
        this.walletId = wallet_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean Is_active() {
        return isActive;
    }

    public void setIs_active(boolean is_active) {
        this.isActive = is_active;
    }
}
