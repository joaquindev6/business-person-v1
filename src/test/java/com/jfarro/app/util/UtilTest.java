package com.jfarro.app.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T readJson(String url, Class<T> resultClass) {
        try {
            return mapper.readValue(
                UtilTest.class.getClassLoader().getResourceAsStream(url), resultClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> readJsonAsList(String url, Class<T> resultClass) {
        try {
            CollectionType listType = mapper.getTypeFactory()
                .constructCollectionType(ArrayList.class, resultClass);
            return mapper.readValue(
                UtilTest.class.getClassLoader().getResourceAsStream(url), listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
