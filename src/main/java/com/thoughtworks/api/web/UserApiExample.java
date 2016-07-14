package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.userExample.UserExample;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class UserApiExample {
    private UserExample user;

    public UserApiExample(UserExample user) {
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserExample getUser() {
        return user;
    }
}
