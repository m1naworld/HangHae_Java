package com.sparta.springproject.dto;

public class PostingResponseDto extends ResponseDto{

    private PostingDto postingDto;

    public PostingResponseDto(String msg, String result, PostingDto postingDto) {
        super(msg, result);
        this.postingDto = postingDto;
    }
}
