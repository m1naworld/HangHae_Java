package com.sparta.springproject.service;

import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.dto.UserDto;
import com.sparta.springproject.entity.User;
import com.sparta.springproject.jwt.JwtUtil;
import com.sparta.springproject.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public ResponseDto insertUser(UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        Optional<User> userFound = userRepository.findByUsername(username);

        if(userFound.isPresent()){
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        User user = new User(username, password);
        userRepository.save(user);

        return new ResponseDto("success", "회원가입 성공!");
    }

    public ResponseDto login(UserDto userDto, HttpServletResponse response){
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        if(!user.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(userDto.getUsername()));

        return new ResponseDto("success", "로그인 성공!");
    }

}
