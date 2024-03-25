package com.payaza.shakorouter.util.exception;

import com.payaza.shakorouter.model.dto.CreateUserDto;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException(CreateUserDto createUserDto) {
        this(String.format("User with username %s or email %s already exists",
                createUserDto.getUsername(), createUserDto.getEmail()));
    }
}
