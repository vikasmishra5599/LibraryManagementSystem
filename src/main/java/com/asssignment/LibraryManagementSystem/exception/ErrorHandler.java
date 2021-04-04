package com.asssignment.LibraryManagementSystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler({FetchFailureException.class})
    public ResponseEntity<Object> handleRuntimeException(FetchFailureException re, WebRequest wr) {
        return handleError(re, wr, INTERNAL_SERVER_ERROR, "failed to fetch");
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleRuntimeException(NotFoundException re, WebRequest wr) {
        return handleError(re, wr, NOT_FOUND, "not found error");
    }

    @ExceptionHandler({CreationFailureException.class})
    public ResponseEntity<Object> handleRuntimeException(CreationFailureException re, WebRequest wr) {
        return handleError(re, wr, INTERNAL_SERVER_ERROR, "failed to create");
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException re, WebRequest wr) {
        return handleError(re, wr, INTERNAL_SERVER_ERROR, "Unexpected server side runtime error occurred");
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception re, WebRequest wr) {
        return handleError(re, wr, INTERNAL_SERVER_ERROR, "Unexpected server side error occurred");
    }

    ResponseEntity<Object> handleError(Exception e, WebRequest webRequest, HttpStatus httpStatus, Object responseBody) {
        LOG.warn("An error occurred while processing request", e);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> errorMap = new LinkedHashMap<>();
        errorMap.put("http-status", httpStatus.value());
        errorMap.put("http-reason", httpStatus.getReasonPhrase());
        errorMap.put("optionalResponse", responseBody);

        return handleExceptionInternal(e, errorMap, headers, httpStatus, webRequest);
    }
}
