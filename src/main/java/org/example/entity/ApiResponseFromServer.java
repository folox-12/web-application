package org.example.entity;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ApiResponseFromServer<T> {
    public String result;
    public T[] records;

    public List<T> getResponse() {
        return Arrays.asList(records);
    }
}

