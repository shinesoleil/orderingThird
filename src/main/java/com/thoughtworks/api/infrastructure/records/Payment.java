package com.thoughtworks.api.infrastructure.records;

import java.util.Date;

public class Payment {
  private String orderId;
  private String payType;
  private Date payTime;
  private float amount;

  public Payment() {
  }

  public Payment(String orderId, String payType, Date payTime, float amount) {
    this.orderId = orderId;
    this.payType = payType;
    this.payTime = payTime;
    this.amount = amount;
  }

  public String getOrderId() {
    return this.orderId;
  }
}
