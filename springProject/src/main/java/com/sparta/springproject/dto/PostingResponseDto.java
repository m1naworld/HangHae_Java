package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostingResponseDto extends ResponseDto{

    private PostingDto postingDto;

    public PostingResponseDto(String result, String message, PostingDto postingDto) {
        super(result, message);
        this.postingDto = postingDto;
    }
}
