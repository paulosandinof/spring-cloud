package com.sandino.spring.roomreservationservice;

import java.time.LocalDate;

public class Reservation {
    private long id;
    private long roomId;
    private long guestId;
    private LocalDate date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation [date=" + date + ", guestId=" + guestId + ", id=" + id + ", roomId=" + roomId + "]";
    }
}
