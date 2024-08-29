package org.example.utils;

import java.net.URI;
import java.net.http.HttpRequest;

public class CustomHttpRequest {
    public static HttpRequest buildHttpGetRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }
}
