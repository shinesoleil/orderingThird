package com.thoughtworks.api.domain.core;
import com.thoughtworks.api.infrastructure.records.User;

public interface UserRepository {
  String generateId();

  void create(User user);

  User findById(String id);
}
