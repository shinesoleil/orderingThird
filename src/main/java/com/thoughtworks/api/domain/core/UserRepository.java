package com.thoughtworks.api.domain.core;

import com.thoughtworks.api.infrastructure.records.User;

import java.util.List;

public interface UserRepository {
  String generateId();

  void create(User user);

  User findById(String id);

  List<User> find();
}
