package com.patrick.booking_service.model;

import com.patrick.booking_service.model.enuns.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID userId;
    private UUID hotelId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer guestCount;
    private Double totalPrice;
    private BookingStatus status;

}
