package org.example.utils;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.example.entity.ApiResponseFromServer;

import java.io.IOException;

public class JsonReader {
    private static final Logger LOG = Logger.getLogger(JsonReader.class);

    public static <T> ApiResponseFromServer<T> getDeserializationObjects(String json, Class<T> classOfDeserialization) {
        ObjectMapper mapper = new ObjectMapper();
        ApiResponseFromServer<T> result = null;
        try {
            result = mapper.readValue(
                    json,
                    mapper.getTypeFactory()
                            .constructParametricType(ApiResponseFromServer.class, classOfDeserialization)
            );
        } catch (IOException e) {
            LOG.error(e);
            System.out.println(e.getMessage());
        }
        return result;
    }
}

