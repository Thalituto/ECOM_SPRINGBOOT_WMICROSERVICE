package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Account;

public interface IAccount extends JpaRepository<Account, Long>{

	Account findByUsername(String name);

}
