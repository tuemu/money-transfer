package com.tuemu.money.transfer.service;

import java.util.List;
import java.util.UUID;

import com.tuemu.money.transfer.model.Account;

public interface AccountApiService {
	public List<Account> getAccounts(UUID userToken);
	public List<Account> getAccountById(UUID userToken, long accountId);
}
