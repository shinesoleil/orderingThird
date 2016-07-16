package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.domain.core.ProductRepository;
import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.infrastructure.records.OrderItem;
import com.thoughtworks.api.infrastructure.records.Payment;
import com.thoughtworks.api.support.DatabaseTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class PaymentRepositoryTest {
  @Inject
  PaymentRepository paymentRepository;

  @Inject
  OrderRepository orderRepository;

  @Inject
  ProductRepository productRepository;

  @Inject
  UserRepository userRepository;

  String productId;
  String userId;
  String orderId;
  String orderItemId;

  @Before
  public void set_up() {
    productId = productRepository.generateId();
    userId = userRepository.generateId();
    orderId = orderRepository.generateId();
    orderItemId = orderRepository.generateOrderItemId();

    productRepository.create(TestHelper.product(productId, 530));
    userRepository.create(TestHelper.user(userId));
    OrderItem orderItem = new OrderItem(orderItemId, 2, productId);
    List<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItem);
    orderRepository.create(TestHelper.order(orderId, orderItems), userId);

  }

  @Test
  public void should_create_payment_with_amount_and_find_by_orderId() {
    Map<String, Object> info = TestHelper.paymentMap(orderId);

    paymentRepository.create(info);

    Payment payment = paymentRepository.findByOrderId(orderId);

    assertThat(payment.getOrderId(), is(orderId));
  }


}
