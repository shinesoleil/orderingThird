package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.records.Product;
import com.thoughtworks.api.support.DatabaseTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class ProductRepositoryTest {
  @Inject
  ProductRepository productRepository;

  @Test
  public void should_create_product_with_name_and_find_by_productId() {
    String id = productRepository.generateId();

    Product product = new Product(id, "desk");

    productRepository.create(product);

    Product createdProduct = productRepository.findById(id);

    assertThat(createdProduct.getName(), is("desk"));
  }
}
