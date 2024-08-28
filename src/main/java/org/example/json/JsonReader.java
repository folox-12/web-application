package org.example.json;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.example.entity.ApiResponseFromServer;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
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

    public static String convertToJson(Object object){
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = writer.writeValueAsString(object);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            LOG.error(e);
        }
        return json;
    }

}

