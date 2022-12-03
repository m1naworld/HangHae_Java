package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {

    private String msg;
    private String result;

    private ResponsePostingDto responsePostingDto;

    public ResponseDto(String msg, String result, ResponsePostingDto responsePostingDto){
        this.msg = msg;
        this.result = result;
        this.responsePostingDto = responsePostingDto;

    }

}
