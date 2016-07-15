package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.core.UserRepository;
import com.thoughtworks.api.infrastructure.records.User;
import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class UsersApiTest extends ApiSupport {
  @Inject
  UserRepository userRepository;

  @Test
  public void should_return_201_when_post_user() {
    Map<String, Object> info = TestHelper.userMap();

    Response post = post("users", info);

    assertThat(post.getStatus(), is(201));
  }

  @Test
  public void return_500_when_post_with_invalid_parameters() {
    Map<String, Object> info = TestHelper.userMap();
    info.replace("name", 123);

    Response post = post("users", info);
    assertThat(post.getStatus(), is(500));
  }

  @Test
  public void should_return_list_of_user_when_get_users() {
    Response get = get("users");

    assertThat(get.readEntity(List.class).size(), is(0));
  }

  @Test
  public void should_return_user_when_get_user_by_id() {
    String id = userRepository.generateId();
    User user = TestHelper.user(id);

    userRepository.create(user);
    Response get = get("users/" + id);

    assertThat(get.getStatus(), is(200));
    assertThat(get.readEntity(User.class).getId(), is(id));
  }

  @Test
  public void should_return_404_when_get_user_by_id_fails() {
    Response get = get("users/2");

    assertThat(get.getStatus(), is(404));
  }
}
