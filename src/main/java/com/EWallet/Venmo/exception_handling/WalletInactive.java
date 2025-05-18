package com.EWallet.Venmo.exception_handling;

public class WalletInactive extends RuntimeException {
    public WalletInactive(String message) {
        super(message);
    }
}
