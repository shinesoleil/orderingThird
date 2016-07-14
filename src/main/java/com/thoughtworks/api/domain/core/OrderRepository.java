package com.thoughtworks.api.domain.core;

import com.thoughtworks.api.infrastructure.records.Order;

public interface OrderRepository {
  String generateId();

  String generateOrderItemId();

  void create(Order order, String orderId);

  Order findById(String id);
}
