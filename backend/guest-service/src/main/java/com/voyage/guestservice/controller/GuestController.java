package com.voyage.guestservice.controller;


import com.voyage.guestservice.dto.GuestDto;
import com.voyage.guestservice.model.Address;
import com.voyage.guestservice.model.CreditCard;
import com.voyage.guestservice.model.Guest;
import com.voyage.guestservice.service.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/guests")
@Slf4j
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public ResponseEntity<List<GuestDto>> allGuests(){
        List<GuestDto> guests = guestService.findAllGuestDto();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @PostMapping("/save")
    public  ResponseEntity<GuestDto> saveGuest(@RequestBody Guest guest){
        Guest updatedGuest = guestService.saveGuest(guest);
        return new ResponseEntity<>(guestService.getGuestDto(guest.getEmail()), HttpStatus.OK) ;
    }



    @PutMapping("/update-address")
    public ResponseEntity<GuestDto> updateGuestAddress(@RequestParam String email, @RequestBody Address address){
        Guest updatedGuest = guestService.updateGuestAddress(email, address);
        return new ResponseEntity<>(guestService.getGuestDto(updatedGuest.getEmail()), HttpStatus.OK) ;
    }
    @DeleteMapping("/delete-address")
    public ResponseEntity<GuestDto> deleteGuestAddress(@RequestParam String email, @RequestBody Address address){
        log.warn("inside deleteGuestAddress ");
        Guest updatedGuest = guestService.deleteGuestAddress(email, address);
        return new ResponseEntity<>(guestService.getGuestDto(updatedGuest.getEmail()), HttpStatus.OK) ;
    }

    @PutMapping("/update-credit-card")
    public ResponseEntity<GuestDto> updateGuestCreditCard(@RequestParam String email, @RequestBody CreditCard creditCard){
        Guest updatedGuest = guestService.updateGuestCreditCard(email, creditCard);
        return new ResponseEntity<>(guestService.getGuestDto(updatedGuest.getEmail()), HttpStatus.OK) ;
    }

}
