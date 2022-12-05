package com.sparta.springproject.controller;

import com.sparta.springproject.dto.PostingRequestDto;
import com.sparta.springproject.dto.PostingResponseDto;
import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.dto.PostingDto;
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
    public ResponseEntity<ResponseDto> findOnePost(@PathVariable Long id)  {
        try {
            PostingDto postingDto = postService.findOnePost(id);
            return ResponseEntity.status(HttpStatus.OK).body(new PostingResponseDto("", "success", postingDto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("게시글이 존재하지 않습니다.", "fail"));
        }
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostingDto>> findAllPost() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.findAllPost());
    }


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/post")
    public PostingDto resisterPost(@RequestBody PostingRequestDto postingRequestDto) {
        return postService.registerPost(postingRequestDto);
    }


    @PutMapping("/post/{id}")
    public ResponseEntity<ResponseDto> updatePost(@PathVariable Long id, @RequestBody PostingRequestDto postingDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.updatePost(id, postingDto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("게시글이 존재하지 않습니다.", "fail"));
        }

    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long id, @RequestBody Map<String, String> password) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.deletePost(id, password.get("password")));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("게시글이 존재하지 않습니다.", "fail"));
        }
    }

}
