package com.utills.urlShortner.model;

import lombok.Data;

@Data
public class UuidRequest {
    private String appName;
    private String environment;
    private long currentTime;
}