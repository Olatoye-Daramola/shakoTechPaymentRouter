package com.payaza.shakorouter.service.user;

import com.payaza.shakorouter.model.dto.ApiResponse;
import com.payaza.shakorouter.model.dto.CreateUserDto;

public interface UserService {

    ApiResponse createUser(CreateUserDto createUserDto);
}
