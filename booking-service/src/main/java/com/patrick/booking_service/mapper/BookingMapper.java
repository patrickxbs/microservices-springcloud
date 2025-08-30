package com.patrick.booking_service.mapper;

import com.patrick.booking_service.dto.BookingRequest;
import com.patrick.booking_service.dto.BookingResponse;
import com.patrick.booking_service.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {

    Booking toBooking(BookingRequest bookingRequest);

    BookingResponse toResponse(Booking booking);
}
