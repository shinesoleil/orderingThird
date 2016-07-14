package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.core.ProductRepository;
import com.thoughtworks.api.infrastructure.records.Product;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("products")
public class ProductsApi {
  @Inject
  ProductRepository productRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createProduct(Map<String, Object> info) {
    String id = productRepository.generateId();
    Product product = new Product(id,
      (String) info.get("name"),
      (String) info.get("description"),
      Float.valueOf(info.get("price").toString()),
      (int) info.get("rating"));

    productRepository.create(product);

    if (productRepository.findById(id) != null) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
  }

  @GET
  public Response findProducts() {
    return Response.status(200).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findProductById(@PathParam("id") String id) {
    return Response.status(200).build();
  }
}
