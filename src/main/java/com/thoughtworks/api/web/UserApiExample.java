package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.user.User;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class UserApiExample {
    private User user;

    public UserApiExample(User user) {
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
        return user;
    }
}
