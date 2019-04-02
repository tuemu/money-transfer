package com.tuemu.money.transfer.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tuemu.money.transfer.model.Account;
import com.tuemu.money.transfer.model.enums.CurrencyEnum;

public class AccountDao {
	public static long USER_ID_1 = 1234;
	
	private static long ACCOUNT_ID_11 = 1111;
	private static CurrencyEnum CURRENCY_11 = CurrencyEnum.JPY;
	private static BigDecimal BALANCE_11 = BigDecimal.valueOf(12000);
	private static long ACCOUNT_ID_12 = 1222;
	private static CurrencyEnum CURRENCY_12 = CurrencyEnum.JPY;
	private static BigDecimal BALANCE_12 = BigDecimal.valueOf(24000);
	
	
	private static List<Account> accountTable = initAccounts();
	
	private static List<Account> initAccounts(){
		List<Account> resultList = new ArrayList<>();
		resultList.add(createAccount(USER_ID_1, ACCOUNT_ID_11, CURRENCY_11, BALANCE_11));
		resultList.add(createAccount(USER_ID_1, ACCOUNT_ID_12, CURRENCY_12, BALANCE_12));
		return resultList;
	}
	
	private static Account createAccount(long userId, long accountId, CurrencyEnum currency, BigDecimal balance) {
		Account account = new Account();
		account.setAccountId(accountId);
		account.setUserId(userId);
		account.setCurrency(currency);
		account.setBalance(balance);
		return account;
	}
	
	public List<Account> getAccounts(long userId) {
		return accountTable.stream()
				.filter(a -> a.getUserId() == userId)
				.collect(Collectors.toList());
	}
}
