package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.core.OrderRepository;
import com.thoughtworks.api.domain.core.ProductRepository;
import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.infrastructure.records.Order;
import com.thoughtworks.api.infrastructure.records.OrderItem;
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
public class OrderApiTest extends ApiSupport{
  @Inject
  ProductRepository productRepository;

  @Inject
  OrderRepository orderRepository;

  @Inject
  UserRepository userRepository;

  String productId1;
  String productId2;
  String userId;
  String orderId;
  String orderItemId1;
  String orderItemId2 ;

  @Before
  public void set_up() {
    productId1 = productRepository.generateId();
    productId2 = productRepository.generateId();
    userId = userRepository.generateId();
    orderId = orderRepository.generateId();
    orderItemId1 = orderRepository.generateOrderItemId();
    orderItemId2 = orderRepository.generateOrderItemId();

    OrderItem orderItem1 = new OrderItem(orderItemId1, 3, productId1);
    OrderItem orderItem2 = new OrderItem(orderItemId2, 1, productId2);
    List<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItem1);
    orderItems.add(orderItem2);
    Order order = TestHelper.order(orderId, orderItems);

    productRepository.create(TestHelper.product(productId1, 530));
    productRepository.create(TestHelper.product(productId2, 210));
    userRepository.create(TestHelper.user(userId));
  }

  @Test
  public void should_return_201_when_post_order_with_name() {
    Map<String, Object> orderItem1 = TestHelper.orderItemMap(3, orderId, productId1);
    Map<String, Object> orderItem2 = TestHelper.orderItemMap(1, orderId, productId2);
    List<Map<String, Object>> orderItems = new ArrayList<>();
    orderItems.add(orderItem1);
    orderItems.add(orderItem2);

    Map<String, Object> info = TestHelper.orderMap(orderItems);

    Response post = post("users/" + userId + "/orders", info);

    assertThat(post.getStatus(), is(201));
  }
}
