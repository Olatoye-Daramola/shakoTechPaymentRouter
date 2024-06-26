package com.payaza.shakorouter.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payaza.shakorouter.util.exception.ValidationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class CustomLogger {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public static void logInfo(String methodName, String message) {
        logger.info("{}.Message: {}\n", methodName, message);
    }

    public static void logError(Throwable throwable) {
        logger.error("Message: {}\n", throwable.getMessage());
        throwable.printStackTrace();
    }

    public static void logError(String methodName, Errors errors) {
        if (errors.hasErrors()) throw new ValidationFailedException(String.format("%s => %s", methodName,
                errors.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining("; "))));
    }

    public static void logRequest(String methodName, Object request) {
        String content = request.toString();
        logger.info("{} [REQUEST] => {}\n", methodName, content);
    }

    public static void logResponse(String methodName, Object response) {
        String content = response.toString();
        logger.info("{} [RESPONSE] => {}\n", methodName, content);
    }
}
