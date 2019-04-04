package com.tuemu.money.transfer.model;

import java.math.BigDecimal;
import java.util.List;

import com.tuemu.money.transfer.model.enums.CurrencyEnum;

import lombok.Data;

/**
 * Account
 */
@Data
public class AccountSuper {
  private List<Account> accounts;
}