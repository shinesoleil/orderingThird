package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.mybatis.mappers.PaymentMapper;
import com.thoughtworks.api.infrastructure.records.Payment;

import javax.inject.Inject;
import java.util.Map;

public class PaymentRepository implements com.thoughtworks.api.domain.core.PaymentRepository {
  @Inject
  PaymentMapper paymentMapper;

  @Override
  public void create(Map<String, Object> info) {
    paymentMapper.save(info);
  }

  @Override
  public Payment findByOrderId(String id) {
    return paymentMapper.findByOrderId(id);
  }
}
