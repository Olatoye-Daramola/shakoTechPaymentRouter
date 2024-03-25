package com.payaza.shakorouter.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserDto {

    @NotEmpty(message = "Username is required")
    private String username;
    @NotEmpty(message = "Password is required")
    private String password;
    @NotEmpty(message = "Email is required")
    private String email;
    @NotEmpty(message = "Firstname is required")
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @NotNull(message = "IsActive is required")
    private boolean isActive;

    @Override
    public String toString() {
        try {
            return new Gson().toJson(this);
        } catch (Exception ex) {
            return super.toString();
        }
    }
}
