package com.example.firstpro.service;

import com.example.firstpro.entity.BookingResponse;
import com.example.firstpro.entity.Seat;
import com.example.firstpro.entity.SeatPrice;
import com.example.firstpro.exception.SeatAlreadyBookedException;
import com.example.firstpro.exception.SeatNotFoundException;
import com.example.firstpro.repo.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepo;

    public List<Seat> getAllSeats(){
        return seatRepo.findAll();
    }

    @Transactional
    public BookingResponse bookSeats(List<Long> seatIds, String user) {

        List<Seat> seats = seatRepo.findAllById(seatIds);

        if (seats.size() != seatIds.size()) {
            throw new SeatNotFoundException("One or more seats not found");
        }

        List<SeatPrice> breakdown = new ArrayList<>();
        double totalPrice = 0;

        for (Seat seat : seats) {

            if (seat.isBooked()) {
                throw new SeatAlreadyBookedException("Seat " + seat.getId() + " already booked");
            }

            double price = calculatePrice(seat.getId());

            totalPrice += price;
            breakdown.add(new SeatPrice(seat.getId(), price));

            seat.setBooked(true);
            seat.setBookedBy(user);
        }

        return new BookingResponse(
                "Last Booking successful",
                breakdown,
                totalPrice
        );
    }



    private double calculatePrice(Long seatId){

        if(seatId >=1 && seatId <= 50){
            return 200;
        } else if (seatId >= 51 && seatId <= 80) {
            return 500;
        } else if (seatId >= 81 && seatId <= 100) {
            return 1000;
        }else {
            throw new RuntimeException("Invalid seat number");
        }
}

}
