package com.thoughtworks.api.infrastructure.records;

public class OrderItem implements com.thoughtworks.api.domain.core.OrderItem {
  private String id;
  private int quantity;
  private String productId;

 public OrderItem() {

 }

  public OrderItem(String id, int quantity, String productId) {
    this.id = id;
    this.quantity = quantity;
    this.productId = productId;
  }
}
