package org.example.RequestAPi;

import java.util.Arrays;
import java.util.List;

public class ResponseFromServer<T> {
    public String result;
    public T[] records;

    public List<T>getResponse() {
        return Arrays.asList(records);
    }
}

