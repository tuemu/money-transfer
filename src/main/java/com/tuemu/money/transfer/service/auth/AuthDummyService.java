package com.tuemu.money.transfer.service.auth;

import java.util.UUID;

import com.tuemu.money.transfer.service.auth.AuthDummyServiceImpl.Session;

public interface AuthDummyService {
	public Session getSession(UUID userToken);

}
