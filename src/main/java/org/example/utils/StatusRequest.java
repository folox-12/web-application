package org.example.utils;

public enum StatusRequest {
    SUCCESS(200),
    ERROR(500);

    private final int title;

    StatusRequest(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }
}
