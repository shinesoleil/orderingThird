package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.records.Product;
import com.thoughtworks.api.support.DatabaseTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class ProductRepositoryTest {
  @Inject
  ProductRepository productRepository;

  @Test
  public void should_create_product_with_name_and_find_by_productId() {
    String id = productRepository.generateId();
    Product product = TestHelper.product(id, 530);

    productRepository.create(product);
    Product createdProduct = productRepository.findById(id);

    assertThat(createdProduct.getId(), is(id));
  }

  @Test
  public void should_find_all_products() {
    String id1 = productRepository.generateId();
    String id2 = productRepository.generateId();
    Product product1 = TestHelper.product(id1, 530);
    Product product2 = TestHelper.product(id2, 210);

    productRepository.create(product1);
    productRepository.create(product2);
    List<Product> products = productRepository.find();

    for (int i = 0; i < products.size(); i++) {
      System.out.println(products.get(i).getName());
    }
    assertThat(products.size(), is(2));
  }
}
