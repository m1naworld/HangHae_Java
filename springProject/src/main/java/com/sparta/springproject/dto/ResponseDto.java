package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {

    protected String result;

    public ResponseDto(String result) {
        this.result = result;
    }
}
