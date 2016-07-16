package com.thoughtworks.api.infrastructure.mybatis.mappers;

import com.thoughtworks.api.infrastructure.records.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PaymentMapper {
  void save(@Param("payment") Map<String, Object> payment);

  Payment findByOrderId(@Param("orderId") String orderId);

  List<Payment> find();
}
