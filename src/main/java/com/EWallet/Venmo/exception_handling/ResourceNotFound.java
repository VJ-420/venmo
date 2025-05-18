package com.EWallet.Venmo.exception_handling;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String msg){
        super(msg);
    }
}
