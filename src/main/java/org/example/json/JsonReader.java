package org.example.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.example.RequestAPi.ResponseFromServer;

import java.io.IOException;

public class JsonReader {

    public static <T> ResponseFromServer<T> getDeserializationObjects(String json, Class<T> classOfDeserialization) {
        ObjectMapper mapper = new ObjectMapper();
        ResponseFromServer<T> result = null;

        try {
            result = mapper.readValue(
                    json,
                    mapper.getTypeFactory()
                            .constructParametricType(ResponseFromServer.class, classOfDeserialization)
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}

