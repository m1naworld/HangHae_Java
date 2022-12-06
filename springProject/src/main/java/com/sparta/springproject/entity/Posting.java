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
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @CreatedDate //entity가 생성되고 저장될때 시간이 자동 저장
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "posting", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public Posting(PostingRequestDto postingRequestDto, String username) {
        this.title = postingRequestDto.getTitle();
        this.username = username;
        this.content = postingRequestDto.getContent();
    }
    // ze
    public Posting(PostingDto postingDto) {
        this.id = postingDto.getId();
        this.title = postingDto.getTitle();
        this.username = postingDto.getUsername();
        this.content = postingDto.getContent();
        this.createdAt = postingDto.getCreatedAt();
        this.modifiedAt = postingDto.getModifiedAt();
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
