package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.records.User;
import com.thoughtworks.api.support.DatabaseTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class UserRepositoryTest {
  @Inject
  UserRepository userRepository;

  @Test
  public void should_create_user_with_name_and_find_by_id() {
    String id = userRepository.generateId();
    User user = new User(id, "firstUser");

    userRepository.create(user);
    User createdUser = userRepository.findById(id);

    assertThat(createdUser.getName(), is("firstUser"));
  }

  @Test
  public void should_find_all_users() {
    String id1 = userRepository.generateId();
    User user1 = new User(id1, "firstUser");
    String id2 = userRepository.generateId();
    User user2 = new User(id2, "secondUser");

    userRepository.create(user1);
    userRepository.create(user2);

    List<User> users = userRepository.find();
    assertThat(users.size(), is(2));
  }
}
