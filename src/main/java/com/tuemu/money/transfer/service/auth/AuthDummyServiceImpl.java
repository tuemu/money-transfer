package com.tuemu.money.transfer.service.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.Value;

public class AuthDummyServiceImpl implements AuthDummyService {
	private static final UUID USER_TOKEN_1 = UUID.fromString("43dee228-8776-4860-a6f1-16691e1476ad");
	private static final long USER_ID_1 = 1000;
	private static final UUID USER_TOKEN_2 = UUID.fromString("09514406-85fd-4edb-b437-d7c888ec1476");
	private static final long USER_ID_2 = 2000;
	private static final UUID ADMIN_TOKEN = UUID.fromString("93da4fb4-dbcd-4fcd-8614-a06e8014b308");
	private static final long ADMIN_ID = 9000;
	
	static private Map<UUID, Session> sessionTable = initSessionTable();
	static private Map<UUID, Session> initSessionTable () {
		Map<UUID, Session> sessionMap = new HashMap<>();
		sessionMap.put(USER_TOKEN_1, new Session(USER_TOKEN_1, USER_ID_1));
		sessionMap.put(USER_TOKEN_2, new Session(USER_TOKEN_2, USER_ID_2));
		sessionMap.put(ADMIN_TOKEN, new Session(ADMIN_TOKEN, ADMIN_ID));
		return sessionMap;
	}

	@Override
	public Session getSession(UUID userToken) {
		if(sessionTable.containsKey(userToken)) {
			return sessionTable.get(userToken);
		} else {
			// For geuses sessions
			return new Session(UUID.randomUUID(), 0);
		}
	}
	
	@Value
	public static class Session{
		UUID userToken;
		long userId;
	}

}
