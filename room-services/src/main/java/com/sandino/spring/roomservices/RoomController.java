package com.sandino.spring.roomservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    
    private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Room> getAllRooms() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Room getRoom(@PathVariable long id){
        return this.repository.findById(id).get();
    }
}
