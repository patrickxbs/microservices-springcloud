package com.patrick.hotel_service.model;

import com.patrick.hotel_service.model.enuns.StatusHotel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "hotels")
public class Hotel {

    @Id
    private UUID id;

    private String code;
    private Integer capacity;
    private StatusHotel status;
    private Double unitPrice;
}
