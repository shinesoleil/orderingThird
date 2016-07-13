package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.mybatis.mappers.ProductMapper;
import com.thoughtworks.api.infrastructure.records.Product;

import javax.inject.Inject;
import java.util.UUID;

public class ProductRepository implements com.thoughtworks.api.domain.core.ProductRepository {
  @Inject
  ProductMapper productMapper;

  @Override
  public String generateId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  @Override
  public void create(Product product) {
    productMapper.save(product);
  }

  @Override
  public Product findById(String id) {
    return productMapper.findById(id);
  }
}
