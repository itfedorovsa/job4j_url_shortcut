package ru.job4j.urlshortcut.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Global exception handler class.
 * Handles all NullPointerException and IllegalArgumentException that occur in all controllers
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 19.04.23
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class.getSimpleName());

    /**
     * ObjectMapper
     */
    private final ObjectMapper objectMapper;

    public GlobalExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Global exception handler
     *
     * @param e        NullPointerException / IllegalArgumentException
     * @param response HttpServletResponse
     * @throws IOException if IOException was thrown
     */
    @ExceptionHandler(value = {NullPointerException.class, IllegalArgumentException.class})
    public void handleException(Exception e, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() {
            {
                put("message", "Some fields is empty");
                put("details", e.getMessage());
            }
        }));
        LOGGER.error(e.getMessage());
    }

}