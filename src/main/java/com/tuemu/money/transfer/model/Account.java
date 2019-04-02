package com.tuemu.money.transfer.model;

import java.math.BigDecimal;

import com.tuemu.money.transfer.model.enums.CurrencyEnum;

import lombok.Data;

/**
 * Account
 */
@Data
public class Account {
  private long accountId;
  private long userId;
  private CurrencyEnum currency;
  private BigDecimal balance;
}