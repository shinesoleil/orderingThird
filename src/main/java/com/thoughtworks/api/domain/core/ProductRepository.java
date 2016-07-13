package com.thoughtworks.api.domain.core;

import com.thoughtworks.api.infrastructure.records.Product;

import java.util.List;

public interface ProductRepository {
  String generateId();

  void create(Product product);

  Product findById(String id);

  List<Product> find();
}
