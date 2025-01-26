package com.utills.urlShortner.service;

import com.utills.urlShortner.UniqueIdException.UniqueIdException;
import com.utills.urlShortner.mapper.UniqueIdMapper;
import com.utills.urlShortner.model.BulkShortIdRequest;
import com.utills.urlShortner.model.BulkShortIdResponse;
import com.utills.urlShortner.model.ShortIdRequest;
import com.utills.urlShortner.model.ShortIdResponse;
import com.utills.urlShortner.model.UuidRequest;
import com.utills.urlShortner.model.UuidResponse;
import com.utills.urlShortner.utils.ShortIdGenerator;
import com.utills.urlShortner.utils.UuidGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Service
@RequiredArgsConstructor
public class UniqueIdServiceImpl implements UniqueIdService {

    @Autowired
    UniqueIdMapper mapper;
    @Autowired
    ShortIdGenerator shortIdGenerator;
    @Autowired
    UuidGenerator uuidGenerator;

    @Override
    public ShortIdResponse generateShortId(ShortIdRequest request) {
       // log.info("Generating short ID for client: {}", request.getClientName());
        try {
            String shortId = shortIdGenerator.generateShortId(request.getShortIdLength());
            String shortUrl = request.getDomainName() + "/" + shortId;

            ShortIdResponse response = mapper.toResponse(request);
            response.setShortId(shortId);
            response.setShortUrl(shortUrl);
            response.setCreatedTime(LocalDateTime.now());
            response.setStatus("SUCCESS");

           // log.info("Short ID generated successfully: {}", shortId);
            return response;
        } catch (Exception e) {
           // log.error("Error generating short ID: {}", e.getMessage());
            throw new UniqueIdException("Failed to generate short ID");
        }
    }

    @Override
    public BulkShortIdResponse generateBulkShortIds(BulkShortIdRequest bulkRequest) {
       // log.info("Generating bulk short IDs for {} requests", bulkRequest.getRequests().size());
        BulkShortIdResponse bulkResponse = new BulkShortIdResponse();
        List<ShortIdResponse> responses = new ArrayList<>();

        for (ShortIdRequest request : bulkRequest.getRequests()) {
            responses.add(generateShortId(request));
        }

        bulkResponse.setResponses(responses);
      //  log.info("Bulk short IDs generated successfully");
        return bulkResponse;
    }

    @Override
    public UuidResponse generateUuid(UuidRequest request) {
        //log.info("Generating UUID for application: {} in environment: {}", request.getAppName(), request.getEnvironment());
        try {
            String uuid = uuidGenerator.generateUuid(request.getEnvironment());
            UuidResponse response = new UuidResponse();
            response.setUuid(uuid);
            response.setStatus("SUCCESS");

          //  log.info("UUID generated successfully: {}", uuid);
            return response;
        } catch (Exception e) {
           // log.error("Error generating UUID: {}", e.getMessage());
            throw new UniqueIdException("Failed to generate UUID");
        }
    }
}