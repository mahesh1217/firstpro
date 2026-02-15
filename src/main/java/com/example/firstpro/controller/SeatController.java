package com.example.firstpro.controller;

import com.example.firstpro.entity.BookingRequest;
import com.example.firstpro.entity.BookingResponse;
import com.example.firstpro.entity.Seat;
import com.example.firstpro.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @GetMapping
    public List<Seat> getSeat(){
        return  seatService.getAllSeats();
    }

    @PostMapping("/book")
    public ResponseEntity<BookingResponse> bookSeats(@RequestBody BookingRequest request) {
                   BookingResponse response = seatService.bookSeats(
                    request.getSeatIds(),
                    request.getUser()
            );
            return ResponseEntity.ok(response);
    }

}
