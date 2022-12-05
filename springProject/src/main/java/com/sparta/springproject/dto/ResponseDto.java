package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {

    private String msg;
    private String result;

    private PostingResponseDto responsePostingDto;

    public ResponseDto(String msg, String result, PostingResponseDto responsePostingDto){
        this.msg = msg;
        this.result = result;
        this.responsePostingDto = responsePostingDto;

    }

}
