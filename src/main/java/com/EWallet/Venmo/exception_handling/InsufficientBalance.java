package com.EWallet.Venmo.exception_handling;

public class InsufficientBalance extends RuntimeException {
    public InsufficientBalance(String message) {

        super(message);
    }
}
