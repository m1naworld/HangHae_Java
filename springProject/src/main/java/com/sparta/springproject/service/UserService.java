package com.sparta.springproject.service;

import com.sparta.springproject.dto.UserRequestDto;
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

    public String insertUser(UserRequestDto userRequestDto) {
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();

        Optional<User> userFound = userRepository.findByUsername(username);

        if(userFound.isPresent()){
            throw new IllegalArgumentException("중복된 username 입니다.");
        }

        User user = new User(username, password);
        userRepository.save(user);

        return "success";
    }

    public String login(UserRequestDto userRequestDto, HttpServletResponse response){
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        if(!user.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        String accessToken = jwtUtil.createToken(username, user.getRole());
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, accessToken);
        return "success";
    }

}
