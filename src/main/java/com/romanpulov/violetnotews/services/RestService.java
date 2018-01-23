package com.romanpulov.violetnotews.services;

import com.romanpulov.violetnotews.model.DataItem;
import com.romanpulov.violetnotews.model.RestDataItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileReader;

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
        result.setName("test name rest");
        return result;
    }

    @Path("/readfile")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String readFile(@QueryParam("filename")String fileName) throws Exception {
        String result;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            result = br.readLine();
        }

        return result;
    }

}
