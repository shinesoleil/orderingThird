package com.thoughtworks.api.domain.core;

import com.thoughtworks.api.infrastructure.records.Payment;

import java.util.Map;

public interface PaymentRepository {
  void create(Map<String, Object> info);

  Payment findByOrderId(String id);
}
