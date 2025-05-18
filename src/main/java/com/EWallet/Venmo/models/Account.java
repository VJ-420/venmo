package com.EWallet.Venmo.models;
import jakarta.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int account_id;
    private double account_bal;
    @Column(unique = true , nullable = false)
    private long account_num;

    @ManyToOne
    @JoinColumn(name = "wallet_id" , referencedColumnName = "wallet_id")
    private Wallet wallet;

    public Account(){

    }
    public Account(int account_id, double account_bal, long account_num, Wallet wallet_id) {
        this.account_id = account_id;
        this.account_bal = account_bal;
        this.account_num = account_num;
        this.wallet = wallet_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getAccount_bal() {
        return account_bal;
    }

    public void setAccount_bal(double account_bal) {
        this.account_bal = account_bal;
    }

    public long getAccount_num() {
        return account_num;
    }

    public void setAccount_num(long account_num) {
        this.account_num = account_num;
    }

    public Wallet getWallet() { return wallet;}

    public void setWallet(Wallet wallet_id) {  this.wallet = wallet_id;}
}
