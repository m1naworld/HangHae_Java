package com.sparta.springproject.dto;

import com.sparta.springproject.entity.Posting;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostingDto{

    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public PostingDto(Posting posting){
        this.id = posting.getId();
        this.title = posting.getTitle();
        this.author = posting.getAuthor();
        this.content = posting.getContent();
        this.createdAt = posting.getCreatedAt();
        this.modifiedAt = posting.getModifiedAt();
    }

}
