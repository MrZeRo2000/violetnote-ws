package com.romanpulov.violetnotews.services;

import com.romanpulov.violetnotews.model.DataItem;
import com.romanpulov.violetnotews.model.RestDataItem;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by rpulov on 09.01.2017.
 */

@Path("/")
public class RestService {

    @Path("/message")
    @GET
    @Produces("text/html")
    public String getMessage() {
        return "Test message from rest!";
    }

    @Path("/dataitem")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DataItem getDataItem() {
        DataItem result = new DataItem();
        result.setId(10);
        result.setName("test name");
        return result;
    }
}
