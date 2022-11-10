package com.coderscampus.Assignment_13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment_13.dto.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}