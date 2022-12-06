package com.sparta.springproject.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {

    @Pattern(regexp = "^[a-z0-9]{4,10}$")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9]{8,15}$")
    private String password;


}
