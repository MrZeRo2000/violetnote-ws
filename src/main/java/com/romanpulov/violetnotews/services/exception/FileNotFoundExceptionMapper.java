package com.romanpulov.violetnotews.services.exception;

import com.romanpulov.violetnotews.model.RestExceptionResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FileNotFoundExceptionMapper implements ExceptionMapper<FileNotFoundException> {
    @Override
    public Response toResponse(FileNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new RestExceptionResponse(Response.Status.NOT_FOUND.getStatusCode(), e.getMessage()))
                .type(MediaType.APPLICATION_JSON).build();
    }
}
