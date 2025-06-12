package com.EWallet.Venmo.repository;

import com.EWallet.Venmo.models.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends CrudRepository<Wallet,Integer> {

}
