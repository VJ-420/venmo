package com.EWallet.Venmo.repository;

import com.EWallet.Venmo.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends CrudRepository<Account,Integer> {
    Optional<Account> findByAccountNum(long accountNum);
}
