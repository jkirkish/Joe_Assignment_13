package com.coderscampus.Assignment_13.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment_13.dto.Account;
import com.coderscampus.Assignment_13.dto.Transaction;
import com.coderscampus.Assignment_13.repository.AccountRepository;
import com.coderscampus.Assignment_13.repository.TransactionRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepo;
	
	public List<Account> findAll () {
		return accountRepo.findAll();
	}

	public Account saveAccount(Account account) {
		
		
		return accountRepo.save(account);
	}

	public void delete(Long accountId) {
		accountRepo.deleteById(accountId);
		
	}
	

}