package com.EWallet.Venmo.controller;

import com.EWallet.Venmo.exception_handling.TransactionFailed;
import com.EWallet.Venmo.models.Transactions;
import com.EWallet.Venmo.models.Wallet;
import com.EWallet.Venmo.service.TransactionService;
import com.EWallet.Venmo.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    private final static Logger logger = LoggerFactory.getLogger(TransactionController.class);


    @GetMapping("/history/{walletId}")
    public List<Transactions> getHistory(
            @PathVariable int walletId) {
        List<Transactions> history =transactionService.getTransactionHistory(walletId);
        return history;
    }

    @PostMapping("/transfer/wallet/{fromId}/{toId}/{amount}")
    public String Wallettransfer(
            @PathVariable("fromId") int fromId,
            @PathVariable("toId") int toId,
            @PathVariable("amount") double amount){
        try{
            transactionService.transfer(fromId,toId,amount);
            logger.info("Transfer Sucess");
            return  "success Transfer completed successfully";
        } catch (Exception e) {
            logger.error("Transaction Failed");
            throw new TransactionFailed("Transaction Failed");
        }
    }

    @PostMapping("/transfer/account/{fromId}/{toId}/{amount}")
    public String accountTransfer(
            @PathVariable int fromId,
            @PathVariable int toId,
            @PathVariable double amount) {
        try {
            transactionService.Accounttransfer(fromId, toId, amount);
            logger.info("transfer success");
            return "success Transfer completed successfully";

        } catch (Exception e) {
            logger.error("Account transfer API failed", e);
            return "Transfer Failed";
        }
    }

}
