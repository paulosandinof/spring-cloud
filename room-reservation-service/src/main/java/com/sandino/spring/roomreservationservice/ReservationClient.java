package com.sandino.spring.roomreservationservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("reservationservices")
public interface ReservationClient {

    @GetMapping("/reservations")
    List<Reservation> getAllReservations(@RequestParam(name = "date", required = false) LocalDate date);

    @GetMapping("/reservations/{id}")
    Reservation gReservation(@PathVariable long id);
}
