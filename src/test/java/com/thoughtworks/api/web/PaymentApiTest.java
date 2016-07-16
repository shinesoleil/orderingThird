package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.core.ProductRepository;
import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.infrastructure.records.OrderItem;
import com.thoughtworks.api.infrastructure.repositories.OrderRepository;
import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class PaymentApiTest extends ApiSupport {

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
  public void should_return_201_when_post_payment() {
    Map<String, Object> info = TestHelper.paymentMap(orderId);

    Response post = post("users/" + userId + "/orders/" + orderId + "/payment", info);

    assertThat(post.getStatus(), is(201));
  }

  @Test
  public void should_return_500_when_post_payment_fails() {
    Map<String, Object> info = TestHelper.paymentMap(orderId);
    info.remove("payType");

    Response post = post("users/" + userId + "/orders/" + orderId + "/payment", info);

    assertThat(post.getStatus(), is(500));
  }
}
