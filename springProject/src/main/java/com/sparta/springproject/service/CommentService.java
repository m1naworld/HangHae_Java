package com.sparta.springproject.service;

import com.sparta.springproject.dto.*;
import com.sparta.springproject.entity.Comment;
import com.sparta.springproject.entity.Posting;
import com.sparta.springproject.jwt.JwtUtil;
import com.sparta.springproject.repository.CommentRepository;
import com.sparta.springproject.repository.PostingRepository;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;
    private final PostingRepository postingRepository;
    private final JwtUtil jwtUtil;

    // jwt를 검증 및 유저 반환
    public String userCheck(HttpServletRequest request) throws JwtException{
        String token = jwtUtil.resolveToken(request);

        if (!jwtUtil.validateToken(token)) {
            throw new JwtException("토큰에러");
        }
        return jwtUtil.getUserInfoFromToken(token);
    }


    // 댓글 등록
    public CommentDto insertComment(Long postId, String comment, HttpServletRequest request) throws JwtException {

        String username = userCheck(request);

        Posting postingFind = postingRepository.findById(postId).orElseThrow(() -> new NullPointerException("게시글 없음"));

        Comment newComment = new Comment(username, comment, postingFind);
        commentRepository.save(newComment);

        return new CommentDto(newComment);
    }


    // 댓글 수정
    @Transactional
    public CommentDto updateComment(Long commentId, String comment, HttpServletRequest request) throws JwtException {

        String username = userCheck(request);

        Comment commentFind = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글 없음"));

        if (commentFind.getUsername().equals(username)) {
            commentFind.update(comment);
            return new CommentDto(commentFind);
        }
        throw new IllegalArgumentException("유저 불일치");

    }

    // 댓글 삭제
    @Transactional
    public String deleteComment(Long commentId, HttpServletRequest request) throws JwtException {

        String username = userCheck(request);

        Comment commentFind = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글 없음"));

        if(commentFind.getUsername().equals(username)){
            commentRepository.deleteById(commentId);
            return "success";
        } throw new IllegalArgumentException("유저 불일치");
    }
}
