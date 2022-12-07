package com.sparta.springproject.dto;

import com.sparta.springproject.entity.UserRoleEnum;
import lombok.Getter;

@Getter
public class UserDto {
    String username;
    UserRoleEnum role;

    public UserDto(String username, UserRoleEnum role) {
        this.username = username;
        this.role = role;
    }
}
