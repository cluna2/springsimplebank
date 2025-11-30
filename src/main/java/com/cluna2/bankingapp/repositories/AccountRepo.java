package com.cluna2.bankingapp.repositories;

import com.cluna2.bankingapp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
