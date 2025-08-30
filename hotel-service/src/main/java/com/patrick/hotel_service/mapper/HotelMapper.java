package com.patrick.hotel_service.mapper;

import com.patrick.hotel_service.dto.HotelRequest;
import com.patrick.hotel_service.dto.HotelResponse;
import com.patrick.hotel_service.model.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HotelMapper {

    Hotel toHotel(HotelRequest hotelRequest);

    HotelResponse toResponse(Hotel hotel);
}
