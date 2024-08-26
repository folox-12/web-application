package org.example.RequestAPi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestApi {
    static HttpClient httpClient = HttpClient.newHttpClient();

   public static String getResponseFromGetRequest(String url) {
       HttpResponse<String> response = null;
       try{
           response = httpClient.send(httpRequest.buildHttpGetRequest(url),
                   HttpResponse.BodyHandlers.ofString());
       } catch (IOException | InterruptedException e) {
           System.out.println("Error: " + e.getMessage());
       }
       return response.body();
   }

}

class httpRequest{
    public static HttpRequest buildHttpGetRequest(String url) {
        return  HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }

}
