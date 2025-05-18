package com.EWallet.Venmo.service;
import com.EWallet.Venmo.models.User;
import com.EWallet.Venmo.models.Wallet;
import com.EWallet.Venmo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo URepo;

    @Autowired
    private WalletService walletService;


    @Override
    public List<User> getAllUser(){
        return (List<User>) this.URepo.findAll();
    }

    @Override
    public User getUserById(int id){
        return this.URepo.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user){
        Wallet w = walletService.addWallet(null);
        user.setWallet_id(w);
        User user1 = this.URepo.save(user);
        return user1;
    }

    @Override
    public User deleteUser(int id){
         this.URepo.deleteById(id);
         return null;
    }

    @Override
    public User update(int id, User user){
        user.setId(id);
        this.URepo.save(user);
        return user;
    }


}
