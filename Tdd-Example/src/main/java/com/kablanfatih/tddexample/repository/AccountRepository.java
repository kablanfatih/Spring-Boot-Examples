package com.kablanfatih.tddexample.repository;

import com.kablanfatih.tddexample.entitiy.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
