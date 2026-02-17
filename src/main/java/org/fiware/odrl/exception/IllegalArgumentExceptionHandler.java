package org.fiware.odrl.exception;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.Instant;

@Provider
public class IllegalArgumentExceptionHandler implements ExceptionMapper<IllegalArgumentException> {
    @Override
    public Response toResponse(IllegalArgumentException exception) {
        Response.Status status = Response.Status.BAD_REQUEST;

        ErrorResponse response = new ErrorResponse(status.getReasonPhrase(), status.getStatusCode(),exception.getMessage(), Instant.now().toEpochMilli());

        return Response.status(Response.Status.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .entity(response).build();
    }
}
