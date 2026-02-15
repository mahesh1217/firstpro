package com.example.firstpro.entity;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequest {
    private List<Long> seatIds;
    private String user;
}
