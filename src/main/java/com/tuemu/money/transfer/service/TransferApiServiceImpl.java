package com.tuemu.money.transfer.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tuemu.money.transfer.dao.TransferDao;
import com.tuemu.money.transfer.model.Transfer;
import com.tuemu.money.transfer.model.Transfer.TransferStatus;
import com.tuemu.money.transfer.service.auth.AuthDummyService;
import com.tuemu.money.transfer.service.auth.AuthDummyServiceImpl;
import com.tuemu.money.transfer.vo.Accounts;
import com.tuemu.money.transfer.vo.Transfers;

public class TransferApiServiceImpl implements TransferApiService {

	private final AuthDummyService auth = new AuthDummyServiceImpl();
	private final TransferDao transferDao = new TransferDao();
	

	@Override
	public Response postTransfer(UUID userToken, long frAccountId, long toAccountId, BigDecimal ammount) {
		long userId = auth.getUserIdByToken(userToken);
				
		List<Transfer> responseList = transferDao.postTransfers(userId, frAccountId, toAccountId, ammount);

		Transfers response = new Transfers(responseList);
		
		return Response.status(Status.OK)
				.entity(response)
    			.header("yourHeaderName", "yourHeaderValue")
    			.type(MediaType.APPLICATION_JSON)
    			.build();
	}

	@Override
	public Response putTransferById(UUID userToken, UUID transferId, long frAccountId, long toAccountId,
			BigDecimal ammount, TransferStatus transferStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getTransfers(UUID userToken) {
		long userId = auth.getUserIdByToken(userToken);
		
		List<Transfer> responseList = transferDao.getTransfers(userId);
		
		Transfers response = new Transfers(responseList);
		
		return Response.status(Status.OK)
				.entity(response)
    			.header("yourHeaderName", "yourHeaderValue")
    			.type(MediaType.APPLICATION_JSON)
    			.build();
	}

	@Override
	public Response getTransferById(UUID userToken, long accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
