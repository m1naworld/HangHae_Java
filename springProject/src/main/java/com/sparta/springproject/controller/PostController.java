package com.sparta.springproject.controller;

import com.sparta.springproject.dto.PostingRequestDto;
import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.dto.PostingResponseDto;
import com.sparta.springproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping("/post/{id}")
    public PostingResponseDto findOnePost(@PathVariable Long id) throws Throwable {
        return postService.findOnePost(id);
    }

    @GetMapping("/post")
    public List<PostingResponseDto> findAllPost(){
        return postService.findAllPost();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/post")
    public PostingResponseDto resisterPost(@RequestBody PostingRequestDto postingDto){
        return postService.registerPost(postingDto);
    }


    @PutMapping("/post/{id}")
    public ResponseEntity<ResponseDto> updatePost(@PathVariable Long id, @RequestBody PostingRequestDto postingDto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.updatePost(id, postingDto));
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long id, @RequestBody Map<String, String> password)  {
        return ResponseEntity.status(HttpStatus.OK).body(postService.deletePost(id, password.get("password")));
    }

}
