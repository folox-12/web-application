package org.example.integration;

public enum StatusRequest {
    SUCCESS (200),
    ERROR (500);

    private int title;

    StatusRequest(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }
}
