package com.sparta.springproject.dto;

import com.sparta.springproject.entity.Posting;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostingDto {

    private Long id;
    private String title;
    private String username;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private List<CommentDto> comments;

    public PostingDto(Posting posting, List<CommentDto> comments){
        this.id = posting.getId();
        this.title = posting.getTitle();
        this.username = posting.getUsername();
        this.content = posting.getContent();
        this.createdAt = posting.getCreatedAt();
        this.modifiedAt = posting.getModifiedAt();
        this.comments = comments;
    }



}
