package com.thoughtworks.api.infrastructure.mybatis.mappers;

import com.thoughtworks.api.infrastructure.records.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
  void save(@Param("user") User user);

  User findById(@Param("id") String id);

  List<User> find();
}
