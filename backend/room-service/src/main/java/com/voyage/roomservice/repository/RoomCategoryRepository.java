package com.voyage.roomservice.repository;


import com.voyage.roomservice.model.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Integer> {
}
