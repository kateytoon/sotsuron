package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {


	@Query("from Account where U_ID = :id")
	public Account findByUsername(@Param("id") String username);

}