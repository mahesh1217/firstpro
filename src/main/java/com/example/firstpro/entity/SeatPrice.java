package com.example.firstpro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatPrice {

    private Long seatId;
    private double price;
}
