package com.EWallet.Venmo.service;

import com.EWallet.Venmo.models.Wallet;

import java.util.List;

public interface WalletService {

    public List<Wallet> getAllWallet();
    public Wallet getWalletById(int id );
    public Wallet addWallet(Wallet wallet);
    public Wallet updateWallet(int id , Wallet wallet);

}
