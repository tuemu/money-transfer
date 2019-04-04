package com.tuemu.money.transfer.vo;

import java.util.List;

import com.tuemu.money.transfer.model.Account;

import lombok.Builder;

@Builder
public class Accounts {
	
	private List<Account> accounts;
}
