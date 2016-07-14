package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.infrastructure.records.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("users")
public class UsersApi {
  @Inject
  UserRepository userRepository;

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
}