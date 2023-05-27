package com.voyage.roomservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(int id){
        super("Room with id: "+id+" does not exist");

    }
}
