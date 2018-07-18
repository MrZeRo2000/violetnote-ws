package com.romanpulov.violetnotews.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.romanpulov.violetnotecore.AESCrypt.AESCryptException;
import com.romanpulov.violetnotecore.AESCrypt.AESCryptService;
import com.romanpulov.violetnotecore.Model.PassData;
import com.romanpulov.violetnotecore.Processor.Exception.DataReadWriteException;
import com.romanpulov.violetnotecore.Processor.XMLPassDataReader;
import com.romanpulov.violetnotews.model.PasswordDataItem;
import com.romanpulov.violetnotews.services.exception.FileNotFoundException;
import com.romanpulov.violetnotews.services.exception.FileReadException;
import com.romanpulov.violetnotews.model.DataItem;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.*;

/**
 * Created by rpulov on 09.01.2017.
 */

@Path("/")
public class RestService {

    @Context Application app;
    @Context
    ServletContext context;

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

    @Path("/props")
    @GET
    @Produces("text/html")
    public String readProperties() {
        return context.getInitParameter("fileName");
    }

    @Path("/readdata")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PassData readData(@QueryParam("password") String password) throws FileReadException, FileNotFoundException

    {
        String fileName = context.getInitParameter("fileName");
        if (fileName == null) {
            throw new FileNotFoundException("null");
        }

        File f = new File(fileName);
        if (f.exists()) {
            try (InputStream input = AESCryptService.generateCryptInputStream(new FileInputStream(f), password)) {
                return (new XMLPassDataReader()).readStream(input);
            } catch (AESCryptException | IOException | DataReadWriteException e) {
                e.printStackTrace();
                if (e instanceof IOException) {
                    throw new FileReadException("Data file read error: " + e.getMessage());
                } else
                    throw new FileReadException("Data decryption error: " + e.getMessage());
            }
        } else
            throw new FileNotFoundException(fileName);
    }

    @Path("/readdatapost")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PassData readDataPost(PasswordDataItem passwordDataItem) throws FileReadException, FileNotFoundException
    {
        String fileName = context.getInitParameter("fileName");
        if (fileName == null) {
            throw new FileNotFoundException("null");
        }

        /*
        PasswordDataItem passwordDataItem;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            passwordDataItem = objectMapper.readValue(data, PasswordDataItem.class);
        } catch (IOException e) {
            throw new FileReadException("Password data read error: " + e.getMessage());
        }
        */

        File f = new File(fileName);
        if (f.exists()) {
            try (InputStream input = AESCryptService.generateCryptInputStream(new FileInputStream(f), passwordDataItem.password)) {
                return (new XMLPassDataReader()).readStream(input);
            } catch (AESCryptException | IOException | DataReadWriteException e) {
                e.printStackTrace();
                if (e instanceof IOException) {
                    throw new FileReadException("Data file read error: " + e.getMessage());
                } else
                    throw new FileReadException("Data decryption error: " + e.getMessage());
            }
        } else
            throw new FileNotFoundException(fileName);
    }


}
