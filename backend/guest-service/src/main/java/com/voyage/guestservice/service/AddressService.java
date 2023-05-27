package com.voyage.guestservice.service;

import com.voyage.guestservice.exception.GuestNotFoundException;
import com.voyage.guestservice.model.Address;
import com.voyage.guestservice.model.Guest;
import com.voyage.guestservice.repository.AddressRepository;
import com.voyage.guestservice.repository.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class AddressService {
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    GuestService guestService;
//    public Guest updateGuestAddress(String email, Address address) {
//        Guest guest = new Guest();
//
//        if(guestRepository.existsByEmail(email)){
//            guest = guestRepository.findGuestByEmail(email);
//            guest.addAddress(address);
//            return guestService.saveGuest(guest);
//        }else{
//            throw new GuestNotFoundException(email);
//        }
//    }
}
