package com.sandino.spring.roomreservationservice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationController {

    private RoomClient roomClient;
    private ReservationClient reservationClient;
    private GuestClient guestClient;

    public RoomReservationController(RoomClient roomClient, ReservationClient reservationClient,
            GuestClient guestClient) {
        this.roomClient = roomClient;
        this.reservationClient = reservationClient;
        this.guestClient = guestClient;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate date) {

        List<Room> rooms = this.roomClient.getAllRooms();
        List<Reservation> reservations = this.reservationClient.getAllReservations(date);

        return rooms.stream().map(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomId(room.getId());

            return roomReservation;
        }).map(roomReservation -> {
            Optional<Reservation> foundReservation = reservations.stream()
                    .filter(reservation -> reservation.getRoomId() == roomReservation.getRoomId()).findFirst();

            if (foundReservation.isPresent()) {
                Guest guest = this.guestClient.getGuest(foundReservation.get().getGuestId());

                roomReservation.setGuestId(guest.getId());
                roomReservation.setFirstName(guest.getFirstName());
                roomReservation.setLastName(guest.getLastName());
                roomReservation.setDate(foundReservation.get().getDate());
            }

            return roomReservation;
        }).collect(Collectors.toList());
    }
}
