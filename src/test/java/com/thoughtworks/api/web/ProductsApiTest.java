package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.core.ProductRepository;
import com.thoughtworks.api.infrastructure.records.Product;
import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class ProductsApiTest extends ApiSupport {
  @Inject
  ProductRepository productRepository;

  @Test
  public void return_201_when_post_product() {
    Map<String, Object> info = new HashMap<>();
    info.put("name", "desk");
    info.put("description", "black");
    info.put("price", 530);
    info.put("rating", 4);

    Response post = post("products", info);
    assertThat(post.getStatus(), is(500));
  }

  @Test
  public void return_400_when_post_with_invalid_parameters() {
    Map<String, Object> info = new HashMap<>();
    info.put("name", "chair");
    info.put("description", 123);
    info.put("price", 210);
    info.put("rating", 5);


    Response post = post("products", info);
    assertThat(post.getStatus(), is(500));
  }

  @Test
  public void return_product_list_when_get_products() {
    Response get = get("products");

    assertThat(get.getStatus(), is(200));
  }

  @Test
  public void should_return_product_when_find_by_id() {
    String id = productRepository.generateId();
    productRepository.create(new Product(id, "chair", "white", 210, 5));

    Response get = get("products/" + id);

    assertThat(get.getStatus(), is(200));
    assertThat(get.readEntity(Product.class).getName(), is("chair"));
  }

  @Test
  public void should_return_404_when_find_by_id_fails() {
    Response get = get("products/2");

    assertThat(get.getStatus(), is(404));
  }
}
