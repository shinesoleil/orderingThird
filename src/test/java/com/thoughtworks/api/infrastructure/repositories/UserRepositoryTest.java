package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.infrastructure.records.User;
import com.thoughtworks.api.support.DatabaseTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

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
}
