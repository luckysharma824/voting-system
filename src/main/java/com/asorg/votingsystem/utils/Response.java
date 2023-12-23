package com.asorg.votingsystem.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Response {
    private Response() {}

    public static ResponseEntity<Object> handleResponse(Object data, String message,
                                                 boolean isSuccess, HttpStatus httpStatus) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("result", data);
        response.put("message", message);
        response.put("isSuccess", isSuccess);
        response.put("timeStamp", LocalDateTime.now());
        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<Object> handleResponse(String message,
                                                        boolean isSuccess, HttpStatus httpStatus) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", message);
        response.put("isSuccess", isSuccess);
        response.put("timeStamp", LocalDateTime.now());
        return new ResponseEntity<>(response, httpStatus);
    }
}
