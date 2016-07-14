package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.records.User;
import com.thoughtworks.api.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class UserRepository implements com.thoughtworks.api.domain.core.UserRepository {
  @Inject
  UserMapper userMapper;

  @Override
  public String generateId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  @Override
  public void create(User user) {
    userMapper.save(user);
  }

  @Override
  public User findById(String id) {
    return userMapper.findById(id);
  }

  @Override
  public List<User> find() {
    return userMapper.find();
  }
}
