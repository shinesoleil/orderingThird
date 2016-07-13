package com.thoughtworks.api.infrastructure.records;

public class Product implements com.thoughtworks.api.domain.core.Product {
  private String id;
  private String name;

  public Product(String id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
