package com.sparta.springproject.entity;

import com.sparta.springproject.dto.PostingRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Posting extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    private String editor;

    @OneToMany(mappedBy = "posting", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    private List<Comment> comments = new ArrayList<>();

    public Posting(PostingRequestDto postingRequestDto, String username) {
        this.title = postingRequestDto.getTitle();
        this.username = username;
        this.content = postingRequestDto.getContent();
    }

    public void update(String title, String content, String editor){
        this.title = title;
        this.content = content;
        this.editor = editor;
    }

}
