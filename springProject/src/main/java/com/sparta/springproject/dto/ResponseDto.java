package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {

    private String msg;
    private String result;

    public ResponseDto(String msg, String result){
        this.msg = msg;
        this.result = result;
    }

}
