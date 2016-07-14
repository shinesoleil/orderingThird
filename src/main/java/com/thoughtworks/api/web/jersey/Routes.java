package com.thoughtworks.api.web.jersey;

import com.thoughtworks.api.domain.userExample.UserExample;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Routes {

    private final String baseUri;

    public Routes(UriInfo uriInfo) {
        baseUri = uriInfo.getBaseUri().toASCIIString();
    }

    public URI userUrl(UserExample user) {
        return URI.create(String.format("%susers/%s", baseUri, user.getUserId().id()));
    }
}
