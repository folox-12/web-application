package org.example.entity;

import jdk.jshell.Snippet;
import org.apache.log4j.Logger;
import org.example.integration.StatusRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;


@Component
public class RequestApi {
    private static final Logger LOG = Logger.getLogger(RequestApi.class);
    static HttpClient httpClient = HttpClient.newHttpClient();
    
   public static ResponseFromServer getResponseFromRequest(String url) {
       HttpResponse<String> responseFromApi = null;
       ResponseFromServer dataToSend = new ResponseFromServer();
       try {
           responseFromApi = httpClient.send(CustomHttpRequest.buildHttpGetRequest(url),
                   HttpResponse.BodyHandlers.ofString());
       } catch (IOException | InterruptedException e) {
           LOG.error(e.getMessage());
           dataToSend.setStatus(StatusRequest.ERROR.getTitle());
           dataToSend.setCode(e.getMessage());
           return dataToSend;
       }
      if(responseFromApi != null) {
          dataToSend.setStatus(responseFromApi.statusCode());
          dataToSend.setCode(responseFromApi.body());
      } else {
          dataToSend.setStatus(StatusRequest.ERROR.getTitle());
      }

      return dataToSend;
   }

}
