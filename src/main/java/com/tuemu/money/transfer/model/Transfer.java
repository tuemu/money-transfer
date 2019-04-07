package com.tuemu.money.transfer.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Builder;
import lombok.Data;

/**
 * Transfer
 */
@Data
@Builder
@XmlRootElement
public class Transfer   {
  @XmlElement
  private long userId;
  @XmlElement
  @Builder.Default
  private UUID transferId = UUID.randomUUID();
  @XmlElement
  private long frAccountId;
  @XmlElement
  private long toAccountId;
  @XmlElement
  private BigDecimal ammount;
  @XmlElement
  @Builder.Default
  private Date transferDate = new Date();
  @XmlElement
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

    @Override
    public String toString() {
      return String.valueOf(value);
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

