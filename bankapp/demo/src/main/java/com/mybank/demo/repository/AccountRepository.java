package com.mybank.demo.repository;

import com.mybank.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository  //database activities
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
