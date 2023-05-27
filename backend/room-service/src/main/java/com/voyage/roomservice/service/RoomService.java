package com.voyage.roomservice.service;

import com.voyage.roomservice.exception.RoomNotFoundException;
import com.voyage.roomservice.model.Room;
import com.voyage.roomservice.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    public Room findRoomById(int id){
        return roomRepository.findById(id).orElseThrow(()-> new RoomNotFoundException(id));
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }
}
