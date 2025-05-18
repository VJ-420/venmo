package com.EWallet.Venmo.service;
import com.EWallet.Venmo.models.Wallet;
import com.EWallet.Venmo.repository.UserRepo;
import com.EWallet.Venmo.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepo walletRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Wallet> getAllWallet(){
        List<Wallet> list = (List<Wallet>) this.walletRepo.findAll();
        return list;
    }

    @Override
    public Wallet getWalletById(int id ){
        Wallet w = this.walletRepo.findById(id).orElse(null);
        return w;
    }


    @Override
    public Wallet addWallet(Wallet wallet){
        if(wallet==null){
            Wallet defwallet = new Wallet();
            defwallet.setBalance(0.00);
            defwallet.setIs_active(true);
            wallet=defwallet;
        }
        Wallet w = this.walletRepo.save(wallet);
        return w;
    }


    @Override
    public Wallet updateWallet(int id , Wallet wallet){
        wallet.setWallet_id(id);
        Wallet w = this.walletRepo.save(wallet);
        return w;
    }


}
