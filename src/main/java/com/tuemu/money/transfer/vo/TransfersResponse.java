package com.tuemu.money.transfer.vo;

import java.util.List;

import com.tuemu.money.transfer.model.Transfer;

import lombok.Data;
import lombok.Setter;

@Data
public class TransfersResponse {
	
	private List<Transfer> transfers;
	
	public TransfersResponse() {
	}
}
