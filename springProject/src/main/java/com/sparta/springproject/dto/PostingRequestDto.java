package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostingRequestDto {

    private Long id;
    private String title;
    private String author;
    private String postPassword;
    private String content;


    public PostingRequestDto(PostingRequestDto postingDto) {
        this.title = postingDto.title;
        this.author = postingDto.author;
        this.postPassword = postingDto.postPassword;
        this.content = postingDto.content;
    }



    public PostingRequestDto(String title, String author, String postPassword, String content){
        this.title = title;
        this.author = author;
        this.postPassword = postPassword;
        this.content = content;
    }

    // dto setter 열려있어도됨

}
