package com.thoughtworks.api.infrastructure.records;

import com.thoughtworks.api.web.jersey.Routes;

import java.util.Date;
import java.util.Map;

public class Payment implements Record{
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

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return null;
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return null;
  }
}
