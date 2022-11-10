package com.coderscampus.Assignment_13.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.Assignment_13.dto.Account;
import com.coderscampus.Assignment_13.dto.Transaction;
import com.coderscampus.Assignment_13.dto.User;
import com.coderscampus.Assignment_13.services.AccountService;
import com.coderscampus.Assignment_13.services.UserService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{userId}/accounts/{accountId}")
	public String getAccounts (ModelMap model,@PathVariable Long userId, @PathVariable Long accountId) {
		User user = userService.findById(userId);
		List<Account> accounts = accountService.findAll();
		model.put("accounts", accounts);
		if (accounts.size() == 1) {
			model.put("account", accounts.iterator().next());
		}
		return "account";
	}
	@PostMapping("/account")
	public String postCreateAccoount(Account account) {
		System.out.println(account);
		accountService.saveAccount(account);
		return "redirect:/account";
	}
	
	
	
	@PostMapping("/accounts/{accountId}")
	public String postOneAccount (Account account) {
		accountService.saveAccount(account);
		return "redirect:/accounts/"+account.getAccountId();
	}
	
	@PostMapping("/accounts/{accountId}/delete")
	public String deleteOneTransaction (@PathVariable Long accountId) {
		accountService.delete(accountId);
		return "redirect:/transactions";
	}
}