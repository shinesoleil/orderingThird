package com.thoughtworks.api.infrastructure.records;

import java.util.Date;
import java.util.List;

public class Order implements com.thoughtworks.api.domain.core.Order {
  private String id;
  private String name;
  private String address;
  private String phone;
  private Date date;
  private List<OrderItem> orderItems;

  public Order() {

  }

  public Order(String id, String name, String address, String phone, Date date, List<OrderItem> orderItems) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.date = date;
    this.orderItems = orderItems;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
