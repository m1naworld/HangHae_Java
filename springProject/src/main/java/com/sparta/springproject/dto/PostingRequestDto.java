package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostingRequestDto {

    private String title;
    private String content;


    public PostingRequestDto(PostingRequestDto postingDto) {
        this.title = postingDto.title;
        this.content = postingDto.content;
    }



    public PostingRequestDto(String title,  String content){
        this.title = title;
        this.content = content;
    }

}
