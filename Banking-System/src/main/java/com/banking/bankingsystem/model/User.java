package com.banking.bankingsystem.model;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="account_number", nullable = true)
    private String accountNumber;

    @Column(name="balance")
    private int balance;

    public User(String fullName, String address, String username,
                String password, String accountNumber, int balance) {
        this.fullName = fullName;
        this.address = address;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public User() {

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
