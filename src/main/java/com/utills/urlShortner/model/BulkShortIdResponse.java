package com.utills.urlShortner.model;

import lombok.Data;

import java.util.List;

@Data
public class BulkShortIdResponse {
    private List<ShortIdResponse> responses;
}