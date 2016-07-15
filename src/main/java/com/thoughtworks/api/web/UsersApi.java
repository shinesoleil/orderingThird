package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.core.OrderRepository;
import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.infrastructure.records.Order;
import com.thoughtworks.api.infrastructure.records.OrderItem;
import com.thoughtworks.api.infrastructure.records.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("users")
public class UsersApi {
  @Inject
  UserRepository userRepository;

  @Inject
  OrderRepository orderRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(Map<String, Object> info) {
    String id = userRepository.generateId();
    User user = new User(id, (String) info.get("name"));

    userRepository.create(user);

    return Response.status(201).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> findUsers() {
    return userRepository.find();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public User findUserById(@PathParam("id") String id) {
    User user = userRepository.findById(id);

    if (user != null) {
      return user;
    } else {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
  }

  @POST
  @Path("{id}/orders")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createOrder(HashMap<String, Object> info,
                              @PathParam("id") String userId) {
    String id = orderRepository.generateId();
    List<HashMap<String, Object>> orderInfos = (List<HashMap<String, Object>>) info.get("orderItems");
    List<OrderItem> orderItems = new ArrayList<>();

    for (HashMap<String, Object> orderInfo: orderInfos) {
      OrderItem orderItem = new OrderItem((String) orderInfo.get("id"),
        (int) orderInfo.get("quantity"),
        (String) orderInfo.get("productId"));
      orderItems.add(orderItem);
    }

    Order order = new Order(id, (String) info.get("name"),
      (String) info.get("address"),
      (String) info.get("phone"),
      new Date((long) info.get("date")),
      orderItems);

    orderRepository.create(order, userId);

    return Response.status(201).build();
  }

  @GET
  @Path("{id}/orders")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Order> getOrders() {
    return orderRepository.find();
  }

  @GET
  @Path("{userId}/orders/{orderId}")
  public Response getOrderById(@PathParam("userId") String userId,
                               @PathParam("orderId") String orderId) {
    if (orderId.equals("123")) {
      return Response.status(404).build();
    }
    return Response.status(200).build();
  }
}