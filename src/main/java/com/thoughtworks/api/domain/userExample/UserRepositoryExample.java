package com.thoughtworks.api.domain.userExample;

import java.util.Optional;

public interface UserRepositoryExample {
    UserExample save(UserExample user);

    Optional<UserExample> ofId(UserId id);

    UserExample findUserByName(String userName);
}
