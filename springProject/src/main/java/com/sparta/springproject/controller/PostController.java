package com.sparta.springproject.controller;

import com.sparta.springproject.dto.PostingDto;
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

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> resisterPost(@RequestBody PostingDto myPostDto){
        System.out.println(myPostDto.getTitle());
        return ResponseEntity.status(HttpStatus.OK).body(postService.registerPost(myPostDto));

    }


}
