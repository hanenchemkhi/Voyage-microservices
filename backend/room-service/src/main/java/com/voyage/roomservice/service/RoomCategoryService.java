package com.voyage.roomservice.service;

import com.voyage.roomservice.model.RoomCategory;
import com.voyage.roomservice.repository.RoomCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomCategoryService {

    private final RoomCategoryRepository roomCategoryRepository;

    public RoomCategoryService(RoomCategoryRepository roomCategoryRepository) {
        this.roomCategoryRepository = roomCategoryRepository;
    }

    public List<RoomCategory> findAllRoomCategories() {
        return roomCategoryRepository.findAll();
    }

    public void saveRoomCategory(RoomCategory roomCategory) {
        roomCategoryRepository.save(roomCategory);
    }
}
