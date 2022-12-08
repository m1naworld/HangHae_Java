package com.sparta.springproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    private String editor;

    private Long postingId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Posting posting;

    public Comment(String username, String content, Long postingId) {
        this.username = username;
        this.content = content;
        this.postingId = postingId;
//        this.posting = posting;
    }

    public void update(String content, String editor){
        this.content = content;
        this.editor = editor;
    }

}
