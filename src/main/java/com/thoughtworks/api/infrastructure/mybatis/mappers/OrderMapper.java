package com.thoughtworks.api.infrastructure.mybatis.mappers;

import com.thoughtworks.api.infrastructure.records.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
  void save(@Param("order") Order order,
            @Param("userId") String userId);

  Order findById(@Param("id") String id);

  List<Order> find();
}
