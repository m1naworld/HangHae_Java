package com.sparta.springproject.controller;

import com.sparta.springproject.dto.PostingDto;
import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/post")
    public ResponseDto resisterPost(@RequestBody PostingDto postingDto){
        return postService.registerPost(postingDto);
    }
    
}
