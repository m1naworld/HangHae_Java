package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {

    private String result;
    private String message;


    public ResponseDto(String result, String message){
        this.result = result;
        this.message = message;

    }

}
