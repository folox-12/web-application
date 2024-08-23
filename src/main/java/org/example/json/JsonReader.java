package org.example.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.example.requestAPi.responseFromServer;

import java.io.IOException;

public class JsonReader {

    public static <T> responseFromServer<T> getDeserializationObjects(String json, Class<T> classOfDeserialization) {
        ObjectMapper mapper = new ObjectMapper();
        responseFromServer<T> result = null;

        try {
            result = mapper.readValue(
                    json,
                    mapper.getTypeFactory()
                            .constructParametricType(responseFromServer.class, classOfDeserialization)
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}

