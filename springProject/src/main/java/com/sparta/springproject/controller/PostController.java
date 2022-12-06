package com.sparta.springproject.controller;

import com.sparta.springproject.dto.PostingRequestDto;
import com.sparta.springproject.dto.PostingResponseDto;
import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.dto.PostingDto;
import com.sparta.springproject.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping("/post/{id}")
    public ResponseEntity<ResponseDto> findOnePost(@PathVariable Long id) {
        try {
            PostingDto postingDto = postService.findOnePost(id);
            return ResponseEntity.status(HttpStatus.OK).body(new PostingResponseDto("success", "게시글 조회 성공!", postingDto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("fail", "게시글이 존재하지 않습니다."));
        }
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostingDto>> findAllPost() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.findAllPost());
    }


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/post")
    public ResponseEntity<ResponseDto> resisterPost(@RequestBody PostingRequestDto postingRequestDto, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.registerPost(postingRequestDto, request));
        } catch (InvalidKeyException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseDto("fail", "토큰 에러"));
        }
    }


    @PutMapping("/post/{id}")
    public ResponseEntity<ResponseDto> updatePost(@PathVariable Long id, @RequestBody PostingRequestDto postingDto, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.updatePost(id, postingDto, request));
        } catch (InvalidKeyException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseDto("fail","토큰이 유효하지 않습니다."));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("fail", "게시글이 존재하지 않습니다."));
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("fail", "작성자만 수정 할 수 있습니다."));
        }

    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long id, @RequestBody Map<String, String> password, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.deletePost(id, password.get("password"), request));
        } catch (InvalidKeyException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseDto("fail","토큰이 유효하지 않습니다."));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("fail", "게시글이 존재하지 않습니다."));
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("fail", "작성자만 삭제할 수 있습니다."));
        }
    }

}
