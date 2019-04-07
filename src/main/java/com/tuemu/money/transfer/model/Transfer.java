package com.tuemu.money.transfer.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transfer
 */
@Builder()
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
public class Transfer   {
  private long userId;
  @Builder.Default
  private UUID transferId = UUID.randomUUID();
  private long frAccountId;
  private long toAccountId;
  private BigDecimal ammount;
  @Builder.Default
  private Date transferDate = new Date();
  @Builder.Default
  private TransferStatus transferStatus = TransferStatus.PLACED;

  /**
   * Transfer Status
   */
  public static enum TransferStatus {
    PLACED("placed"),
    APPROVED("approved"),
    CANCELLED("cancelled");

    private String value;

    TransferStatus(String value) {
      this.value = value;
    }

    public static TransferStatus fromValue(String text) {
      for (TransferStatus b : TransferStatus.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
}

