package com.thoughtworks.api.infrastructure.repositories;


import com.thoughtworks.api.domain.core.ProductRepository;
import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.infrastructure.records.Order;
import com.thoughtworks.api.infrastructure.records.OrderItem;
import com.thoughtworks.api.support.DatabaseTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class OrderRepositoryTest {

  @Inject
  OrderRepository orderRepository;

  @Inject
  UserRepository userRepository;

  @Inject
  ProductRepository productRepository;

  @Test
  public void should_create_order_with_parameters_and_find_by_userId_and_orderId() {
    String productId1 = productRepository.generateId();
    String productId2 = productRepository.generateId();
    String userId = userRepository.generateId();
    String orderId = orderRepository.generateId();
    String orderItemId1 = orderRepository.generateOrderItemId();
    String orderItemId2 = orderRepository.generateOrderItemId();

    OrderItem orderItem1 = new OrderItem(orderItemId1, 3, productId1);
    OrderItem orderItem2 = new OrderItem(orderItemId2, 1, productId2);
    List<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItem1);
    orderItems.add(orderItem2);
    Order order = TestHelper.order(orderId, orderItems);

    productRepository.create(TestHelper.product(productId1, 530));
    productRepository.create(TestHelper.product(productId2, 210));
    userRepository.create(TestHelper.user(userId));
    orderRepository.create(order, userId);
    Order createdOrder = orderRepository.findById(orderId);

    assertThat(createdOrder.getId(), is(orderId));
  }
}
