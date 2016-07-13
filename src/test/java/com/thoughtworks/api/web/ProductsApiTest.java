package com.thoughtworks.api.web;

import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class ProductsApiTest extends ApiSupport {

  @Test
  public void return_201_when_post_product() {
    Map<String, Object> info = new HashMap<>();
    info.put("name", "desk");

    Response post = post("products", info);
    assertThat(post.getStatus(), is(201));
  }
}
