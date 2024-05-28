package com.asorg.votingsystem.utils;

import com.asorg.votingsystem.exception.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class JsonMapperUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

    public static String toJson(Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new ServiceException("EC-JSON-MAP", ex.getMessage());
        }
    }

    public static <T> T toObject(Reader reader, TypeReference<T> tClass) {
        try {
            return MAPPER.readValue(reader, tClass);
        } catch (IOException ex) {
            throw new ServiceException("EC-JSON-MAP", ex.getMessage());
        }
    }
}
