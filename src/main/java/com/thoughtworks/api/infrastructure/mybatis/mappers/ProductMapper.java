package com.thoughtworks.api.infrastructure.mybatis.mappers;

import com.thoughtworks.api.infrastructure.records.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
  void save(@Param("product") Product product);

  Product findById(@Param("id") String id);
}
