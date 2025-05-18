package com.EWallet.Venmo.repository;

import com.EWallet.Venmo.models.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepo extends CrudRepository<Transactions,Integer> {

    List<Transactions> findByWallet_WalletId(int walletId);
    Optional<Transactions> findTopByWallet_WalletIdOrderByDateDesc(int walletId);
}
