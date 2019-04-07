package com.tuemu.money.transfer.service;

import java.math.BigDecimal;
import java.util.UUID;

import javax.ws.rs.core.Response;

import com.tuemu.money.transfer.model.Transfer.TransferStatus;

public interface TransferApiService {
	public Response postTransfer(UUID userToken, long frAccountId, long toAccountId,
			BigDecimal ammount);
	public Response putTransferById(UUID userToken, UUID transferId, TransferStatus transferStatus);
	public Response getTransfers(UUID userToken);
	public Response getTransferById(UUID userToken, long accountId);
}
