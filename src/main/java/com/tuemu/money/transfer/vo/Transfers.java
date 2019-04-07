package com.tuemu.money.transfer.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tuemu.money.transfer.model.Transfer;

import lombok.Data;
import lombok.Value;

@Value
@XmlRootElement
public class Transfers {
	
	@XmlElement
	private List<Transfer> transfers;
}
