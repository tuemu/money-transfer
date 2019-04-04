package com.tuemu.money.transfer.service;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tuemu.money.transfer.dao.AccountDao;
import com.tuemu.money.transfer.model.Account;
import com.tuemu.money.transfer.service.auth.AuthDummyService;
import com.tuemu.money.transfer.service.auth.AuthDummyServiceImpl;
import com.tuemu.money.transfer.vo.Accounts;

public class AccountApiServiceImpl implements AccountApiService {

	private final AuthDummyService auth = new AuthDummyServiceImpl();
	private final AccountDao accountDao = new AccountDao();
	

	@Override
	public Response getAccounts(UUID userToken) {
		long userId = auth.getUserIdByToken(userToken);
		List<Account> responseList = accountDao.getAccounts(userId);

		Accounts aa = Accounts.builder().accounts(responseList).build();
		
		return Response.status(Status.OK)
				.entity(aa)
    			.header("yourHeaderName", "yourHeaderValue")
    			.type(MediaType.APPLICATION_JSON)
    			.build();
	}

	@Override
	public Response getAccountById(UUID userToken, long accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
