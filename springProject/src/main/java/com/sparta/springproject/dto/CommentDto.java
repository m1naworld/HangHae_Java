package com.sparta.springproject.dto;

import com.sparta.springproject.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String username;
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;


    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getUsername();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
