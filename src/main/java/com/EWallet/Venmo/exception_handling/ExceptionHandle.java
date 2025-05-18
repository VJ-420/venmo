package com.EWallet.Venmo.exception_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = ResourceNotFound.class)
    public ResponseEntity ResourceNotFound(){
        logger.error("Resource not Found");
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UnableToAdd.class)
    public ResponseEntity UnableToAdd(){
        logger.error("Unable to add");
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = InsufficientBalance.class)
    public ResponseEntity InsufficientBalance(){
        logger.error("Not enough Balance");
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = WalletInactive.class)
    public ResponseEntity WalletInactive(){
        logger.error("Wallet is not active");
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TransactionFailed.class)
    public ResponseEntity TransactionFailed(){
        logger.error("Transaction Failed");
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
