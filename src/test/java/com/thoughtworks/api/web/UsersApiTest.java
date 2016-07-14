package com.thoughtworks.api.web;

import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class UsersApiTest extends ApiSupport {

  @Test
  public void should_return_201_when_post_user() {
    Map<String, Object> info = new HashMap<>();
    info.put("name", "firstUser");

    Response post = post("users", info);

    assertThat(post.getStatus(), is(201));
  }

  @Test
  public void return_500_when_post_with_invalid_parameters() {
    Map<String, Object> info = new HashMap<>();
    info.put("name", 123);

    Response post = post("users", info);
    assertThat(post.getStatus(), is(500));
  }

  @Test
  public void should_return_list_of_user_when_get_users() {
    Response get = get("users");

    assertThat(get.readEntity(List.class).size(), is(0));
  }

  @Test
  public void should_return_200_when_get_user_by_id() {
    Response get = get("users/1");

    assertThat(get.getStatus(), is(200));
  }
}
