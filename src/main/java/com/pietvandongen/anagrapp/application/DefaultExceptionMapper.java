package com.pietvandongen.anagrapp.application;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

    private final static Logger LOGGER = Logger.getLogger(DefaultExceptionMapper.class.getName());

    @Override
    public Response toResponse(Exception exception) {
        Response.ResponseBuilder responseBuilder;

        if (exception instanceof WebApplicationException) {
            WebApplicationException webApplicationException = (WebApplicationException) exception;
            responseBuilder = Response.fromResponse(webApplicationException.getResponse());
        } else {
            responseBuilder = Response.serverError();
        }

        String message;

        if (exception.getMessage() == null) {
            message = "An internal server error occurred.";
        } else {
            message = exception.getMessage();
        }

        LOGGER.log(Level.SEVERE, message, exception);

        JsonObject error = Json.createObjectBuilder()
                .add("message", message)
                .build();

        return responseBuilder
                .entity(error.toString())
                .build();
    }
}
