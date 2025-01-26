package com.utills.urlShortner.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShortIdResponse {
    private String clientName;
    private String longUrl;
    private String shortId;
    private String shortUrl;
    private LocalDateTime createdTime;
    private String status;
}