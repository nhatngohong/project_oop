package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtil {
    public static <T> String toJson(T data) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            System.out.println("cannot to json");
        }
        return json;
    }

    public static <T> T toObject(String data, Class<T> type){
        ObjectMapper objectMapper = new ObjectMapper();
        T object = null;
        try {
            object = objectMapper.readValue(data, type);
        } catch (JsonProcessingException e) {
            System.out.println("cannot to object");
        }
        return object;
    }
}
