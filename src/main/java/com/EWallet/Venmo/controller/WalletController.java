package com.EWallet.Venmo.controller;

import com.EWallet.Venmo.exception_handling.ResourceNotFound;
import com.EWallet.Venmo.models.Wallet;
import com.EWallet.Venmo.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;
    private final static Logger logger = LoggerFactory.getLogger(WalletController.class);

    @GetMapping("/getWallet/{id}")
    public Wallet getWalletbyId(@PathVariable("id") int id){
        Wallet w = this.walletService.getWalletById(id);
        if(w==null){
            logger.warn("Wallet not found");
            throw new ResourceNotFound("Wallet not Found");
        }
        logger.info("Wallet given");
        return w;
    }

    @PutMapping("/updateBalance/{id}")
    public Wallet updateBalance(@PathVariable("id")int id , @RequestBody Wallet wallet) throws Exception {

        Wallet existing = this.walletService.getWalletById(id);
        if(existing == null ){
            logger.error("Wallet not found");
            throw new ResourceNotFound("Wallet not found");
        }else {
            existing.setBalance(wallet.getBalance());
        }

        Wallet w = this.walletService.updateWallet(id, existing);
        if (w == null) {
            logger.error("Unable to update");
            throw new Exception("Unable to update");
        }

        logger.info("Wallet updated");
        return w;
    }

    @PutMapping("/updateStatus/{id}")
    public Wallet updateStatus (@PathVariable ("id") int id , @RequestBody Wallet wallet ) throws Exception {
        Wallet existing = this.walletService.getWalletById(id);
        if(existing == null ){
            logger.error("Wallet not found");
            throw new ResourceNotFound("Wallet not found");
        }else {
            existing.setIs_active(wallet.Is_active());
        }

        Wallet w = this.walletService.updateWallet(id, existing);
        if (w == null) {
            logger.error("Unable to update");
            throw new Exception("Unable to update");
        }

        logger.info("Wallet updated");
        return w;

    }



}
