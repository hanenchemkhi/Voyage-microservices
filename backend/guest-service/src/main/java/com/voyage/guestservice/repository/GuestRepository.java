package com.voyage.guestservice.repository;

import com.voyage.guestservice.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
    Guest findGuestByEmail(String email);
    boolean existsById(Integer id);
    boolean existsByEmail(String email);
}
