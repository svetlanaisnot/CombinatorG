package com.combinatorg.model.old.social;

/**
 * Created by svetlana on 08/01/15.
 */
public class DownloadResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DownloadResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
