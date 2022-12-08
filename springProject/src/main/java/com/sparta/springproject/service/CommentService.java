package com.sparta.springproject.service;

import com.sparta.springproject.dto.*;
import com.sparta.springproject.entity.Comment;
import com.sparta.springproject.entity.Posting;
import com.sparta.springproject.entity.UserRoleEnum;
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

    // 댓글 등록
    public CommentDto insertComment(Long postId, String comment, HttpServletRequest request) throws JwtException {

        UserDto user = jwtUtil.userCheck(request);
        String username = user.getUsername();

        Posting postingFind = postingRepository.findById(postId).orElseThrow(() -> new NullPointerException("게시글 없음"));

//        Comment newComment = new Comment(username, comment, postingFind);
        Comment newComment = new Comment(username, comment, postingFind.getId());
        commentRepository.save(newComment);

        return new CommentDto(newComment);
    }


    // 댓글 수정
    @Transactional
    public CommentDto updateComment(Long commentId, String comment, HttpServletRequest request) throws JwtException {
        UserDto user = jwtUtil.userCheck(request);
        String username = user.getUsername();
        UserRoleEnum role = user.getRole();

        Comment commentFind = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글 없음"));

        if (commentFind.getUsername().equals(username) || role.equals(UserRoleEnum.ADMIN)) {
            commentFind.update(comment, username);
            return new CommentDto(commentFind);
        }
        throw new IllegalArgumentException("유저 불일치");

    }

    // 댓글 삭제
    @Transactional
    public String deleteComment(Long commentId, HttpServletRequest request) throws JwtException {
        UserDto user = jwtUtil.userCheck(request);
        String username = user.getUsername();
        UserRoleEnum role = user.getRole();

        Comment commentFind = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글 없음"));

        if(commentFind.getUsername().equals(username) || role.equals(UserRoleEnum.ADMIN)){
            commentRepository.deleteById(commentId);
            return "success";
        } throw new IllegalArgumentException("유저 불일치");
    }
}
