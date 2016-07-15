package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.records.User;
import com.thoughtworks.api.support.DatabaseTestRunner;
import com.thoughtworks.api.support.TestHelper;
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
    User user = TestHelper.user(id);

    userRepository.create(user);
    User createdUser = userRepository.findById(id);

    assertThat(createdUser.getId(), is(id));
  }

  @Test
  public void should_find_all_users() {
    String id1 = userRepository.generateId();
    String id2 = userRepository.generateId();
    User user1 = TestHelper.user(id1);
    User user2 = TestHelper.user(id2);

    userRepository.create(user1);
    userRepository.create(user2);

    List<User> users = userRepository.find();
    assertThat(users.size(), is(2));
  }
}
