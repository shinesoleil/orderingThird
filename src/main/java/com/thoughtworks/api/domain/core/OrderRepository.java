package com.thoughtworks.api.domain.core;

import com.thoughtworks.api.infrastructure.records.Order;

public interface OrderRepository {
  String generateId();

  void create(Order order);

  Order findById(String id);
}
