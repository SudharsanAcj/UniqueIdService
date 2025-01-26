package com.utills.urlShortner.controller;

import com.utills.urlShortner.model.BulkShortIdRequest;
import com.utills.urlShortner.model.BulkShortIdResponse;
import com.utills.urlShortner.model.ShortIdRequest;
import com.utills.urlShortner.model.ShortIdResponse;
import com.utills.urlShortner.model.UuidRequest;
import com.utills.urlShortner.model.UuidResponse;
import com.utills.urlShortner.service.UniqueIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unique-id")
@RequiredArgsConstructor
public class UniqueIdController {

    @Autowired
     UniqueIdService uniqueIdService;

    @PostMapping("/short-id")
    public ResponseEntity<ShortIdResponse> sortIDGenerator(@RequestBody ShortIdRequest request) {
        ShortIdResponse response = uniqueIdService.generateShortId(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/short-id/bulk")
    public ResponseEntity<BulkShortIdResponse> sortIDGeneratorBulk(@RequestBody BulkShortIdRequest bulkRequest) {
        BulkShortIdResponse response = uniqueIdService.generateBulkShortIds(bulkRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/uuid")
    public ResponseEntity<UuidResponse> uUidGenerator(@RequestBody UuidRequest request) {
        UuidResponse response = uniqueIdService.generateUuid(request);
        return ResponseEntity.ok(response);
    }
}