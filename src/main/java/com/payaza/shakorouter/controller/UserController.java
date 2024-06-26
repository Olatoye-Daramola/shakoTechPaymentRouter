package com.payaza.shakorouter.controller;

import com.payaza.shakorouter.model.dto.ApiResponse;
import com.payaza.shakorouter.model.dto.CreateUserDto;
import com.payaza.shakorouter.service.user.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import static com.payaza.shakorouter.util.CustomLogger.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@NotNull(message = "Valid request body is required") @Valid
                                                  @RequestBody CreateUserDto request, @ApiIgnore Errors errors) {
        logRequest("UserController.createUser", request.toString());
        logError("UserController.createUser", errors);
        ApiResponse response = userService.createUser(request);
        logResponse("UserController.createUser", response.toString());
        return ResponseEntity.ok(response);
    }
}
