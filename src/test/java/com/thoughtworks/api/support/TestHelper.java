package com.thoughtworks.api.support;

import com.thoughtworks.api.domain.userExample.UserExample;
import com.thoughtworks.api.domain.userExample.UserId;
import com.thoughtworks.api.domain.userExample.UserRepositoryExample;
import com.thoughtworks.api.domain.userExample.UserRole;
import com.thoughtworks.api.infrastructure.records.Order;
import com.thoughtworks.api.infrastructure.records.OrderItem;
import com.thoughtworks.api.infrastructure.records.Product;
import com.thoughtworks.api.infrastructure.records.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    public static Map<String, Object> productMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "desk");
        map.put("description", "black");
        map.put("price", 530);
        map.put("rating", 4);

        return map;
    }

    public static Product product(String id, float price) {
        return new Product(id, "product" + id, "black", price, 5);
    }

    public static Map<String, Object> userMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "firstUser");

        return map;
    }

    public static User user(String id) {
        return new User(id, "user" + id);
    }

    public static Map<String, Object> orderMap(List<Map<String, Object>> orderItems) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "firstUser");
        map.put("address", "beijing");
        map.put("phone", "13099999999");
        map.put("date", new Date());
        map.put("orderItems", orderItems);

        return map;
    }

    public static Map<String, Object> orderItemMap(int quantity, String orderId, String productId) {
        Map<String, Object> map = new HashMap<>();
        map.put("quantity", quantity);
        map.put("orderId", orderId);
        map.put("productId", productId);

        return map;
    }

    public static Order order(String id, List<OrderItem> orderItems) {
        return new Order(id, "order" + id, "Beijing", "13099999999", new Date(), orderItems);
    }
}
