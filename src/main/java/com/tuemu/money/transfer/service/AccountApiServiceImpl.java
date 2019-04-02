package com.tuemu.money.transfer.service;

import java.util.List;
import java.util.UUID;

import com.tuemu.money.transfer.dao.AccountDao;
import com.tuemu.money.transfer.model.Account;
import com.tuemu.money.transfer.service.auth.AuthDummyService;
import com.tuemu.money.transfer.service.auth.AuthDummyServiceImpl;

public class AccountApiServiceImpl implements AccountApiService {

	private final AuthDummyService auth = new AuthDummyServiceImpl();
	private final AccountDao accountDao = new AccountDao();
	

	@Override
	public List<Account> getAccounts(UUID userToken) {
		long userId = auth.getUserIdByToken(userToken);
		return accountDao.getAccounts(userId);
	}

	@Override
	public List<Account> getAccountById(UUID userToken, long accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
