package com.sparta.springproject.controller;

import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.dto.UserDto;
import com.sparta.springproject.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(@RequestBody @Valid UserDto userDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.insertUser(userDto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDto("fail", "중복된 사용자가 존재합니다."));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody UserDto userDto, HttpServletResponse response) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.login(userDto, response));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDto("fail", "아이디 혹은 비밀번호가 일치하지 않습니다."));
        }

    }


}
