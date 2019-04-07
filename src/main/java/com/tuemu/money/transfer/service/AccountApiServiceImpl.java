package com.tuemu.money.transfer.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.persistence.internal.libraries.asm.signature.SignatureWriter;

import com.tuemu.money.transfer.dao.AccountDao;
import com.tuemu.money.transfer.model.Account;
import com.tuemu.money.transfer.service.auth.AuthDummyService;
import com.tuemu.money.transfer.service.auth.AuthDummyServiceImpl;
import com.tuemu.money.transfer.vo.Accounts;

public class AccountApiServiceImpl implements AccountApiService, AccountApiServiceForBackend {

	private final AuthDummyService auth = new AuthDummyServiceImpl();
	private final AccountDao accountDao = new AccountDao();
	

	@Override
	public Response getAccounts(UUID userToken) {
		long userId = auth.getSession(userToken).getUserId();
		List<Account> responseList = accountDao.getAccounts(userId);

		Accounts aa = new Accounts(responseList);
		
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

	@Override
	public boolean isWithdrawalPossible(long targetAccountId, BigDecimal ammount) {
		Optional<Account> account = accountDao.findAccount(targetAccountId);
		if(account.isPresent()) {
			System.out.println(" Account Balance: " + account.get().getBalance());
			System.out.println(" Ammount which will be withdrawed: " + ammount);
			System.out.println(" Compareing result: " + (account.get().getBalance().compareTo(ammount) > 0));
			return (account.get().getBalance().compareTo(ammount) > 0);
		}
		return false;
	}
	
	public boolean hasAccount(long accountId) {
		Optional<Account> account = accountDao.findAccount(accountId);
		return account.isPresent();
	}
	
	public boolean transferMoney(long frAccountId, long toAccountId, BigDecimal ammount) {
		System.out.println(" START transferMoney().");
		if(isWithdrawalPossible(frAccountId, ammount)) {
			Optional<Account> frAccount = accountDao.findAccount(frAccountId);
			Optional<Account> toAccount = accountDao.findAccount(toAccountId);
			if (!frAccount.isPresent() || !toAccount.isPresent()) {
				System.out.println(" Either or Neither of account is NOT exist.");
				return false;
			}
			
			// These are backup before transfer.
			BigDecimal orgFrBalance = frAccount.get().getBalance();
			BigDecimal orgToBalance = toAccount.get().getBalance();
			try {
				frAccount.get().setBalance(orgFrBalance.subtract(ammount));
				toAccount.get().setBalance(orgToBalance.add(ammount));
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(" System Error in Money Transfer.");
				System.out.println(e.getMessage());
				// Restore in case of happening someghin.
				frAccount.get().setBalance(orgFrBalance);
				toAccount.get().setBalance(orgToBalance);
				return false;
			} finally {
			}
		}
		return false;
	}
	
}
