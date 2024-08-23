package org.example.requestAPi;

import java.util.Arrays;
import java.util.List;

public class responseFromServer<T> {
    public String result;
    public T[] records;

    public List<T>getResponse() {
        return Arrays.asList(records);
    }
}

