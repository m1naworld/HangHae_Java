package com.sparta.springproject.controller;

import com.sparta.springproject.dto.CommentDto;
import com.sparta.springproject.dto.CommentResponseDto;
import com.sparta.springproject.dto.ErrorMessageDto;
import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.service.CommentService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping("/comment/{postId}")
    public ResponseEntity<ResponseDto> insertComment(@PathVariable Long postId, @RequestBody Map<String, String> comment, HttpServletRequest request) {
        try {
            CommentDto commentDto = commentService.insertComment(postId, comment.get("comment"), request);
            return ResponseEntity.status(HttpStatus.OK).body(new CommentResponseDto(commentDto));
        } catch (JwtException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorMessageDto("토큰이 유효하지 않습니다."));
        } catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDto("게시글이 존재하지 않습니다."));
        }
    }


    @PutMapping("/comment/{commentId}")
    public ResponseEntity<ResponseDto> updateComment(@PathVariable Long commentId, @RequestBody Map<String, String> comment, HttpServletRequest request) {
        try {
            CommentDto commentDto = commentService.updateComment(commentId, comment.get("comment"), request);
            return ResponseEntity.status(HttpStatus.OK).body(new CommentResponseDto(commentDto));
        } catch (JwtException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorMessageDto("토큰이 유효하지 않습니다."));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDto("게시글이 존재하지 않습니다."));
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageDto("작성자만 수정 할 수 있습니다."));
        }
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long commentId, HttpServletRequest request) {
        try {
            String result = commentService.deleteComment(commentId, request); // success
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(result));
        } catch (JwtException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseDto("토큰이 유효하지 않습니다."));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("게시글이 존재하지 않습니다."));
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("작성자만 삭제할 수 있습니다."));
        }
    }


}
