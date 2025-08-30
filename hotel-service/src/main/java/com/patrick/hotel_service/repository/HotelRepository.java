package com.patrick.hotel_service.repository;

import com.patrick.hotel_service.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface HotelRepository extends MongoRepository<Hotel, UUID> {
}
