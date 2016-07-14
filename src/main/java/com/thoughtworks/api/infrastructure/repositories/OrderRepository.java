package com.thoughtworks.api.infrastructure.repositories;


import com.thoughtworks.api.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.api.infrastructure.records.Order;

import javax.inject.Inject;
import java.util.UUID;

public class OrderRepository implements com.thoughtworks.api.domain.core.OrderRepository {
  @Inject
  OrderMapper orderMapper;

  @Override
  public String generateId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  @Override
  public void create(Order order) {
    orderMapper.save(order);
  }

  @Override
  public Order findById(String id) {
    return orderMapper.findById(id);
  }
}
