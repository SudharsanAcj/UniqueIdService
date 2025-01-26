package com.utills.urlShortner.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ShortIdGenerator {
    private static final String BASE62_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final Random random = new Random();

    public String generateShortId(int length) {
        StringBuilder shortId = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(BASE62_CHARS.length());
            shortId.append(BASE62_CHARS.charAt(index));
        }
        return shortId.toString();
    }
}