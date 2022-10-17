package com.example.demo.mapper;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public interface JsonMapper {
    ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        return defaultObjectMapper;
    }

    public static JsonNode parse(String string) throws IOException {
        return objectMapper.readTree(string);
    }
    public static <A> A fromJson(JsonNode node, Class<A> aClass) throws IOException {
        return objectMapper.treeToValue(node, aClass);
    }

    public static JsonNode toJson(Object a) {
        return objectMapper.valueToTree(a);
    }
}
