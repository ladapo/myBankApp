package com.mybank.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@Entity
@Table(name = "accounts")
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
@Column(name = "account_name")
    private String accountName;
    @Column(name = "account_number")
    private int accountNumber;
    @Column(name = "account_balance")
    private double accountBalance;
    public Account() {
        super();
    }
    public Account(int id,String accountName, int accountNumber, double accountBalance){
        super();
        this.id= id;
        this.accountName= accountName;
        this.accountNumber= accountNumber;
        this.accountBalance= accountBalance;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
       this.accountName= accountName;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber= accountNumber;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance= accountBalance;
    }
}
