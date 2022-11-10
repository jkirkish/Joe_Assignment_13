package com.coderscampus.Assignment_13.web;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.stream.Stream;
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
	public String getAccounts(ModelMap model, @PathVariable Long userId, @PathVariable Long accountId) {
		User user = userService.findById(userId);
		Stream<Account> account = accountService.findAccountById(accountId, user);
		Account dummyAccount = account.iterator().next();
		model.put("user", user);
		model.put("account", dummyAccount);
		return "accounts";
	}
	@PostMapping("/users/{userId}/accounts")
	public String postAccount(@PathVariable Long userId, User user) {
		Long accountNum = accountService.addAccount(user);
		userService.saveUser(user);
		return "redirect:/users/" + userId + "/accounts/" + accountNum;
	}
	@PostMapping("/users/{userId}/accounts/{accountId}")
	public String updateAccount(@PathVariable Long userId, @PathVariable Long accountId, Account account, User user) {
		User userUpdate = accountService.saveAccount(account, user);
		userService.saveUser(userUpdate);
		return "redirect:/users/" + userId + "/accounts/" + accountId;
	}


}