package com.payaza.shakorouter.util;

import com.payaza.shakorouter.model.constant.ApiResponseStatus;
import com.payaza.shakorouter.model.constant.ISO8583Code;
import com.payaza.shakorouter.model.dto.ApiResponse;
import com.payaza.shakorouter.util.exception.MissingHeaderAttributeException;
import com.payaza.shakorouter.util.exception.UserAlreadyExistsException;
import com.payaza.shakorouter.util.exception.ValidationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLSyntaxErrorException;

import static com.payaza.shakorouter.util.CustomLogger.logError;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {UserAlreadyExistsException.class, ValidationFailedException.class,
            HttpMessageNotReadableException.class, MissingHeaderAttributeException.class, IllegalArgumentException.class})
    public ResponseEntity<?> badRequestError(Exception ex) {
        logError(ex);
        ApiResponse response = new ApiResponse();
        response.setError(true);
        response.setStatus(ApiResponseStatus.FAILED.getStatus());
        response.setMessage(ex.getMessage());
        if (ex instanceof HttpMessageNotReadableException) response.setMessage("Bad request body");
        response.setResponseCode(ISO8583Code.FORMAT_ERROR.getCode());
        return ResponseEntity.badRequest().body(response);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {SQLSyntaxErrorException.class})
    public ResponseEntity<?> internalServerError(Exception ex) {
        logError(ex);
        ApiResponse response = new ApiResponse();
        response.setError(true);
        response.setStatus(ApiResponseStatus.FAILED.getStatus());
        response.setMessage("Internal Server Error");
        response.setResponseCode(ISO8583Code.SYSTEM_ERROR.getCode());
        return ResponseEntity.internalServerError().body(response);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<?> accessDeniedError(Exception ex) {
        logError(ex);
        ApiResponse response = new ApiResponse();
        response.setError(true);
        response.setStatus(ApiResponseStatus.FAILED.getStatus());
        response.setMessage(ex.getMessage());
        response.setResponseCode(ISO8583Code.SECURITY_VIOLATION.getCode());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
