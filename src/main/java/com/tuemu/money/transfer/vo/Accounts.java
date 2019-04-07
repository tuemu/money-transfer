package com.tuemu.money.transfer.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.tuemu.money.transfer.model.Account;

import lombok.Value;

@Value
public class Accounts {
	
	private List<Account> accounts;
}
