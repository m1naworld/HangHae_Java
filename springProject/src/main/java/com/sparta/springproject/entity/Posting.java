package com.sparta.springproject.entity;

import com.sparta.springproject.dto.PostingRequestDto;
import com.sparta.springproject.dto.PostingDto;
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

    public Posting(PostingRequestDto postingRequestDto) {
        this.title = postingRequestDto.getTitle();
        this.author = postingRequestDto.getAuthor();
        this.postPassword = postingRequestDto.getPostPassword();
        this.content = postingRequestDto.getContent();
    }

    public Posting(PostingDto postingDto) {
        this.id = postingDto.getId();
        this.title = postingDto.getTitle();
        this.author = postingDto.getAuthor();
        this.content = postingDto.getContent();
        this.createdAt = postingDto.getCreatedAt();
        this.modifiedAt = postingDto.getModifiedAt();
    }

    public void update(PostingRequestDto postingRequestDto){
        this.title = postingRequestDto.getTitle();
        this.content = postingRequestDto.getContent();
    }

}
