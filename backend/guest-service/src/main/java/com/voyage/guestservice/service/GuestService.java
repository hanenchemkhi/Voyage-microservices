package com.voyage.guestservice.service;

import com.voyage.guestservice.dto.GuestDto;
import com.voyage.guestservice.exception.GuestNotFoundException;
import com.voyage.guestservice.model.Address;
import com.voyage.guestservice.model.CreditCard;
import com.voyage.guestservice.model.Guest;

import com.voyage.guestservice.repository.AddressRepository;
import com.voyage.guestservice.repository.GuestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Slf4j
@Service
public class GuestService {
    @Autowired
    private final GuestRepository guestRepository;
    @Autowired
    private final AddressRepository addressRepository;
    public List<Guest> findAllGuests(){
        return guestRepository.findAll();
    }
    public Guest findGuestByEmail(String email){
        return guestRepository.findGuestByEmail(email);
    }

    public Guest saveGuest(Guest guest){
        Guest _guest = new Guest();

        if (guestRepository.existsByEmail(guest.getEmail())) {
            _guest = guestRepository.findGuestByEmail(guest.getEmail());

        }else {
            _guest.setFirstName(guest.getFirstName());
            _guest.setLastName(guest.getLastName());
            _guest.setEmail(guest.getEmail());
            _guest.setPassword(guest.getPassword());
            _guest.setAddresses(guest.getAddresses());

            for(CreditCard card: guest.getCreditCards()){
                _guest.addCreditCard(card);
            }

            _guest = guestRepository.save(_guest);

        }
        return _guest ;
    }
    public Guest updateGuestAddress(String email, Address address) {
        Guest guest = new Guest();
        if(guestRepository.existsByEmail(email)){
            guest = guestRepository.findGuestByEmail(email);
            guest.addAddress(address);
            return guestRepository.save(guest);
        }else{
            throw new GuestNotFoundException(email);
        }
    }
    public Guest updateGuestCreditCard(String email, CreditCard creditCard){

        Guest guest = new Guest();
        if(guestRepository.existsByEmail(email)){
            guest = guestRepository.findGuestByEmail(email);
            guest.addCreditCard(creditCard);
            return guestRepository.save(guest);
        }else{
            throw new GuestNotFoundException(email);
        }
    }


    public Guest deleteGuestAddress(String email, Address address) {
        Guest guest = new Guest();
        if(guestRepository.existsByEmail(email)){
            guest = guestRepository.findGuestByEmail(email);
            addressRepository.delete(address);
            guest.removeAddress(address);
            return guestRepository.save(guest);
        }else{
            throw new GuestNotFoundException(email);
        }
    }

    public List<GuestDto> findAllGuestDto() {
        return findAllGuests()
                .stream()
                .map(guest -> getGuestDto(guest.getEmail()))
                .collect(Collectors.toList());
    }

    public GuestDto getGuestDto(String email) {
        Guest guest = guestRepository.findGuestByEmail(email);
        return new GuestDto(guest.getFirstName(), guest.getLastName(), guest.getEmail());
    }
}
