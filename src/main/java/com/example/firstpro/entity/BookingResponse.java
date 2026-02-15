package com.example.firstpro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookingResponse {

    private String message;
    private List<SeatPrice> setPrices;
    private double totalPrice;
}
