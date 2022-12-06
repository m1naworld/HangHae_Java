package com.sparta.springproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Posting posting;

    public Comment(String username, String content, Posting posting) {
        this.username = username;
        this.content = content;
        this.posting = posting;
    }

    public void update(String content){
        this.content = content;
    }

}
