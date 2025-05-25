package com.EWallet.Venmo.repository;

import com.EWallet.Venmo.models.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepo extends CrudRepository<Transactions,Integer> {

    @Query("SELECT t FROM Transactions t WHERE t.senderWalletId = :walletId")
    List<Transactions> findByWallet_WalletId(@Param("walletId") int walletId);
    Optional<Transactions> findTopByWallet_WalletIdOrderByDateDesc(int walletId);
}
