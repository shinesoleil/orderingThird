package com.thoughtworks.api.support;

import com.thoughtworks.api.domain.userExample.UserExample;
import com.thoughtworks.api.domain.userExample.UserId;
import com.thoughtworks.api.domain.userExample.UserRepositoryExample;
import com.thoughtworks.api.domain.userExample.UserRole;

import java.util.HashMap;
import java.util.Map;

public class TestHelper {
    private static int auto_increment_key = 1;
    public static Map<String, Object> deployment(String appName, String releaseId) {
        return new HashMap<String, Object>() {{
            put("app", String.format("http://service-api.tw.com/apps/%s", appName));
            put("release", String.format("http://service-api.tw.com/apps/%s/releases/%s", appName, releaseId));
        }};
    }

    public static Map<String, Object> stackMap(String id, String name) {
        Map<String, Object> stackMap = new HashMap<String, Object>() {{
            put("id", id);
            put("name", name);
        }};
        return stackMap;
    }

    public static Map<String, Object> userMap(String email, String name) {
        return new HashMap<String, Object>() {{
            put("name", name);
            put("email", email);
        }};
    }

    public static UserExample userForTest(String id, String name, UserRole role) {
        String password_123 = "$2a$04$DbgJbGA4dkQSzAvXvJcGBOv5kHuMBzrWfne3x3Cx4JQv4IJcxtBIW";
        return new UserExample(new UserId(id), name, name + "@tw.com", role, password_123);
    }

    public static UserExample userFixture(UserRepositoryExample userRepository, UserRole role) {
        final String id = new Integer(auto_increment_key++).toString();
        UserExample user = userForTest(id, "name-" + id, role);
        userRepository.save(user);
        return user;
    }

    public static Map<String, Object> userJsonForTest(UserExample user) {
        return new HashMap<String, Object>() {{
            put("id", user.getUserId().id());
            put("role", user.getRole());
        }};
    }
}
