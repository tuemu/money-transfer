package com.tuemu.money.transfer.service.auth;

import java.util.UUID;

import com.tuemu.money.transfer.dao.AccountDao;

public class AuthDummyServiceImpl implements AuthDummyService {

	@Override
	public long getUserIdByToken(UUID userToken) {
		return AccountDao.USER_ID_1;
	}

}
