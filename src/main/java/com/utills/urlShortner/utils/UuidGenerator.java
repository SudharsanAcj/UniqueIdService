package com.utills.urlShortner.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {
    public String generateUuid(String environment) {
        String uuid = UUID.randomUUID().toString().substring(0, 12);
        return environment + "-" + uuid;
    }
}