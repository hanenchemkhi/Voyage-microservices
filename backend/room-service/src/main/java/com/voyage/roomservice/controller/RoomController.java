package com.voyage.roomservice.controller;

import com.voyage.roomservice.model.Room;
import com.voyage.roomservice.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@Slf4j
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping
    public ResponseEntity<List<Room>> viewAllRooms(){
        return new ResponseEntity<>(roomService.findAllRooms(),  HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> saveRoom(@RequestBody Room room){
        roomService.saveRoom(room);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
