package com.example.firstpro.config;

import com.example.firstpro.entity.Seat;
import com.example.firstpro.repo.SeatRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DataLoader {
    private final SeatRepository seatRepo;

    @PostConstruct
    public void loadSeats() {
        if (seatRepo.count() == 0) {
            for (long i = 1; i <= 100; i++) {
                Seat seat = new Seat();
                seat.setId(i);
                seat.setBooked(false);
                seatRepo.save(seat);
            }
        }
    }

}
