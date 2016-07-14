package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.records.Order;
import com.thoughtworks.api.support.DatabaseTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class OrderRepositoryTest {

  @Inject
  OrderRepository orderRepository;

  @Test
  public void should_create_order_with_name_and_find_by_Id() {
    String id = orderRepository.generateId();
    Order order = new Order(id ,"firstOrder");

    orderRepository.create(order);
    Order createdOrder = orderRepository.findById(id);

    assertThat(createdOrder.getName(), is("firstOrder"));
  }
}
