package com.romanpulov.violetnotews.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by rpulov on 09.01.2017.
 */

@Path("/")
public class RestService {

    @Path("/message")
    @GET
    @Produces("text/html")
    public String getMessage() {
        return "Test message";
    }
}
