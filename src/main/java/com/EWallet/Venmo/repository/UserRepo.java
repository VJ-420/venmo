package com.EWallet.Venmo.repository;

import com.EWallet.Venmo.models.User;
import com.EWallet.Venmo.models.Wallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.wallet.walletId = :walletId")
    Optional<User> findByWalletId(@Param("walletId") int walletId);
}