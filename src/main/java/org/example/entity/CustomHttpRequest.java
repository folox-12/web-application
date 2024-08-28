package org.example.entity;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpRequest;

@Component
public class CustomHttpRequest {
    public static HttpRequest buildHttpGetRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }
}
