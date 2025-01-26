package com.utills.urlShortner.model;

import lombok.Data;

@Data
public class ShortIdRequest {
    private String clientName;
    private String longUrl;
    private String domainName;
    private int shortIdLength;
}