package com.tuemu.money.transfer.service;

import java.util.UUID;

import javax.ws.rs.core.Response;

public interface AccountApiService {
	public Response getAccounts(UUID userToken);
	public Response getAccountById(UUID userToken, long accountId);
}
