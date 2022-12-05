package com.sparta.springproject.entity;

import com.sparta.springproject.dto.PostingRequestDto;
import com.sparta.springproject.dto.PostingResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String postPassword;

    @Column(nullable = false)
    private String content;

    @CreatedDate //entity가 생성되고 저장될때 시간이 자동 저장
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Posting(PostingRequestDto postDto) {
        this.title = postDto.getTitle();
        this.author = postDto.getAuthor();
        this.postPassword = postDto.getPostPassword();
        this.content = postDto.getContent();
    }

    public Posting(PostingResponseDto responsePostingDto) {
        this.id = responsePostingDto.getId();
        this.title = responsePostingDto.getTitle();
        this.author = responsePostingDto.getAuthor();
        this.content = responsePostingDto.getContent();
        this.createdAt = responsePostingDto.getCreatedAt();
        this.modifiedAt = responsePostingDto.getModifiedAt();
    }

    public void update(PostingRequestDto postingDto){
        this.title = postingDto.getTitle();
        this.content = postingDto.getContent();
    }

}
