package com.EWallet.Venmo.exception_handling;

public class TransactionFailed extends RuntimeException {
    public TransactionFailed(String msg ){super(msg);}
}
