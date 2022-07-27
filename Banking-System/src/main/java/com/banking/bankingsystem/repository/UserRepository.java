package com.banking.bankingsystem.repository;

import com.banking.bankingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByAccountNumber(String accountNumber);
}
