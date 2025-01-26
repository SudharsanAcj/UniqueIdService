package com.utills.urlShortner.service;

import com.utills.urlShortner.model.BulkShortIdRequest;
import com.utills.urlShortner.model.BulkShortIdResponse;
import com.utills.urlShortner.model.ShortIdRequest;
import com.utills.urlShortner.model.ShortIdResponse;
import com.utills.urlShortner.model.UuidRequest;
import com.utills.urlShortner.model.UuidResponse;

public interface UniqueIdService {
    ShortIdResponse generateShortId(ShortIdRequest request);
    BulkShortIdResponse generateBulkShortIds(BulkShortIdRequest bulkRequest);
    UuidResponse generateUuid(UuidRequest request);
}