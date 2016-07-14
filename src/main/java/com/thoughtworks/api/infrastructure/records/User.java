package com.thoughtworks.api.infrastructure.records;

public class User implements com.thoughtworks.api.domain.core.User {
  private String id;
  private String name;

  public User() {

  }

  public User(String id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
