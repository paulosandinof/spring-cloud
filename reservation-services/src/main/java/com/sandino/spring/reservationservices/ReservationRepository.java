package com.sandino.spring.reservationservices;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findAllByDate(LocalDate date);
}
