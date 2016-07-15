package com.thoughtworks.api.infrastructure.repositories;


import com.thoughtworks.api.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.api.infrastructure.records.Order;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class OrderRepository implements com.thoughtworks.api.domain.core.OrderRepository {
  @Inject
  OrderMapper orderMapper;

  @Override
  public String generateId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  @Override
  public String generateOrderItemId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  @Override
  public void create(Order order, String userId) {
    orderMapper.save(order, userId);
  }

  @Override
  public Order findById(String id) {
    return orderMapper.findById(id);
  }

  @Override
  public List<Order> find() {
    return orderMapper.find();
  }
}
