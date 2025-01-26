package com.utills.urlShortner.mapper;

import com.utills.urlShortner.model.ShortIdRequest;
import com.utills.urlShortner.model.ShortIdResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniqueIdMapper {
    ShortIdResponse toResponse(ShortIdRequest request);
}