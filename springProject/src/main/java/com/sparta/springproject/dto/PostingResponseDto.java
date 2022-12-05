package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostingResponseDto extends ResponseDto{

    private PostingDto postingDto;

    public PostingResponseDto(String msg, String result, PostingDto postingDto) {
        super(msg, result);
        this.postingDto = postingDto;
    }
}
