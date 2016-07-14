package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.infrastructure.records.User;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("users")
public class UsersApi {
  @Inject
  UserRepository userRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(Map<String, Object> info) {
    String id = userRepository.generateId();
    User user = new User(id, (String)info.get("name"));

    userRepository.create(user);

    return Response.status(201).build();
  }

  @GET
  public Response findUsers() {
    return Response.status(200).build();
  }
}
