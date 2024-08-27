package org.example.entity;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;


public class RequestApi {
    private static final Logger LOG = Logger.getLogger(RequestApi.class);
    static HttpClient httpClient = HttpClient.newHttpClient();
    
   public static String getResponseFromRequest(String url) {
       HttpResponse<String> response = null;
       try {
           response = httpClient.send(CustomHttpRequest.buildHttpGetRequest(url),
                   HttpResponse.BodyHandlers.ofString());
       } catch (IOException | InterruptedException e) {
           System.out.println("Error: " + e.getMessage()); // логирование
       }
       return response != null ? response.body() : null;
   }

}
