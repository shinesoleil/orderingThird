package com.thoughtworks.api.domain.core;

import com.thoughtworks.api.infrastructure.records.Order;

import java.util.List;

public interface OrderRepository {
  String generateId();

  String generateOrderItemId();

  void create(Order order, String orderId);

  Order findById(String id);

  List<Order> find();
}
