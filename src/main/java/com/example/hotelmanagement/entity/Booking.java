package com.example.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String customerName;
    private String customerEmail;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;


    @ManyToOne
    private Room room;
}
