package com.thoughtworks.api.infrastructure.records;

public class Order implements com.thoughtworks.api.domain.core.Order {
  private String id;
  private String name;

  public Order(String id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
