package com.tuemu.money.transfer.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tuemu.money.transfer.model.Account;
import com.tuemu.money.transfer.model.enums.CurrencyEnum;

public class AccountDao {
	public static long USER_ID_1 = 1000;
	
	private static long ACCOUNT_ID_11 = 1001;
	private static CurrencyEnum CURRENCY_11 = CurrencyEnum.JPY;
	private static BigDecimal BALANCE_11 = BigDecimal.valueOf(12000);
	private static long ACCOUNT_ID_12 = 1002;
	private static CurrencyEnum CURRENCY_12 = CurrencyEnum.JPY;
	private static BigDecimal BALANCE_12 = BigDecimal.valueOf(24000);
	
	public static long USER_ID_2 = 2000;
	
	private static long ACCOUNT_ID_21 = 2001;
	private static CurrencyEnum CURRENCY_21 = CurrencyEnum.JPY;
	private static BigDecimal BALANCE_21 = BigDecimal.valueOf(12000);
	
	private static Map<Long, Account> accountTable = initAccounts();
	
	private static Map<Long, Account> initAccounts(){
		Map<Long, Account> resultMap = new HashMap<>();
		resultMap.put(ACCOUNT_ID_11, createAccount(USER_ID_1, ACCOUNT_ID_11, CURRENCY_11, BALANCE_11));
		resultMap.put(ACCOUNT_ID_12, createAccount(USER_ID_1, ACCOUNT_ID_12, CURRENCY_12, BALANCE_12));
		resultMap.put(ACCOUNT_ID_21, createAccount(USER_ID_2, ACCOUNT_ID_21, CURRENCY_21, BALANCE_21));
		return resultMap;
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
		 return accountTable.entrySet().stream()
				 .map(c -> {
					 System.out.println(c.toString());
					 return c.getValue();	 
				 })
				 .filter(a -> a.getUserId() == userId)
				 .collect(Collectors.toList());
	}
	
	public Optional<Account> findAccount(long accountId) {
		return Optional.ofNullable(accountTable.get(new Long((long)accountId)));
	}
}
