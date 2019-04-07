package com.tuemu.money.transfer.service;

import java.math.BigDecimal;
import java.util.UUID;

import javax.ws.rs.core.Response;

public interface AccountApiServiceForBackend {
	boolean isWithdrawalPossible(long targetAccountId, BigDecimal ammount);
	boolean hasAccount(long accountId);
	boolean transferMoney(long frAccountId, long toAccountId, BigDecimal ammount);
}
