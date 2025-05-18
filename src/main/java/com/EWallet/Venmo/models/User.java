package com.EWallet.Venmo.models;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String name;
    private String email;
    @Column(unique = true, nullable = false)
    private int mobile_no;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet_id;


    public User (){

    }

    public User(int id, String name, String email, int mobile_no, Wallet wallet_id) {
        this.user_id = id;
        this.name = name;
        this.email = email;
        this.mobile_no = mobile_no;
        this.wallet_id = wallet_id;
    }

    public Wallet getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id( Wallet wallet_id) {
        this.wallet_id=wallet_id;
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

    public int getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(int mobile_no) {
        this.mobile_no = mobile_no;
    }

}
