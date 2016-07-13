package com.thoughtworks.api.infrastructure.records;

public class Product implements com.thoughtworks.api.domain.core.Product {
  private String id;
  private String name;
  private String description;
  private float price;
  private int rating;

  public Product() {

  }

  public Product(String id, String name, String description, float price, int rating) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.rating = rating;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
