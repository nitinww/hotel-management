package com.example.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String roomNumber;
    private String type;
    private double price;
    private boolean available = true;
}
