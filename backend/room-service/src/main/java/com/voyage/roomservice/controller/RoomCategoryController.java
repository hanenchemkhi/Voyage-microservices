package com.voyage.roomservice.controller;


import com.voyage.roomservice.model.RoomCategory;
import com.voyage.roomservice.service.RoomCategoryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-categories")
@Slf4j
public class RoomCategoryController {

    private final RoomCategoryService roomCategoryService;

    public RoomCategoryController(RoomCategoryService roomCategoryService) {
        this.roomCategoryService = roomCategoryService;
    }


    @GetMapping
    public ResponseEntity<List<RoomCategory>> viewAllRooms(){
        return new ResponseEntity<>(roomCategoryService.findAllRoomCategories(),  HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> saveRoom(@RequestBody RoomCategory roomCategory){
        roomCategoryService.saveRoomCategory(roomCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

