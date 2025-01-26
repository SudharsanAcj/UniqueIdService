package com.utills.urlShortner.model;

import lombok.Data;

import java.util.List;

@Data
public class BulkShortIdRequest {
    private List<ShortIdRequest> requests;
}
