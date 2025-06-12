package com.EWallet.Venmo.models;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String name;
    private String email;
    @Column(unique = true, nullable = false)
    private String mobilenum;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;


    public User (){

    }

    public User(int id, String name, String email, String mobilenum, Wallet wallet_id) {
        this.user_id = id;
        this.name = name;
        this.email = email;
        this.mobilenum = mobilenum;
        this.wallet = wallet_id;
    }

    public Wallet getWallet_id() {
        return wallet;
    }

    public void setWallet_id( Wallet wallet_id) {
        this.wallet=wallet_id;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenum() {
        return mobilenum;
    }

    public void setMobilenum(String mobilenum) {
        this.mobilenum = mobilenum;
    }

}
