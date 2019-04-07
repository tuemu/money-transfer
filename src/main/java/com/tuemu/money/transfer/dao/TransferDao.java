package com.tuemu.money.transfer.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tuemu.money.transfer.model.Transfer;
import com.tuemu.money.transfer.model.enums.CurrencyEnum;

public class TransferDao {
	public static long USER_ID_1 = 1234;
	
	private static long FR_ACCOUNT_ID_11 = 12340001;
	private static long TO_ACCOUNT_ID_11 = 22340001;
	private static BigDecimal AMMOUNT_11 = new BigDecimal(123456);
	
		
	private static List<Transfer> transferTable = initTranfers();
	
	private static List<Transfer> initTranfers(){
		List<Transfer> resultList = new ArrayList<>();
		resultList.add(Transfer.builder()
				.userId(USER_ID_1)
				.frAccountId(FR_ACCOUNT_ID_11)
				.toAccountId(TO_ACCOUNT_ID_11)
				.ammount(AMMOUNT_11)
				.build());
		return resultList;
	}
	
	private static Transfer createTransfer(
			long userId,
			long frAccountId,
			long toAccountId,
			BigDecimal ammount) {
		Transfer transfer = Transfer.builder()
				.userId(userId)
				.frAccountId(frAccountId)
				.toAccountId(toAccountId)
				.ammount(ammount)
				.build();
		return transfer;
	}
	
	public List<Transfer> getTransfers(long userId) {
		return transferTable.stream()
				.filter(a -> a.getUserId() == userId)
				.collect(Collectors.toList());
	}
	
	public List<Transfer> postTransfers(long userId, long frAccountId, long toAccountId,
			BigDecimal ammount) {
		Transfer newTransfer = createTransfer(userId, frAccountId, toAccountId, ammount);
		transferTable.add(newTransfer);
		
		List<Transfer> responseList = new ArrayList<>();
		responseList.add(newTransfer);
		return responseList;
	}
}
