package com.voyage.guestservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class GuestNotFoundException extends RuntimeException{
    public GuestNotFoundException(String email){
        super("Guest with email: "+ email+" does not exist");
    }

}
