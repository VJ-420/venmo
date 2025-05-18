package com.EWallet.Venmo.exception_handling;

public class UnableToAdd extends RuntimeException{

    public UnableToAdd(String msg){
        super(msg);
    }
}
