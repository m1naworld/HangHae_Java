package com.sparta.springproject.dto;

import lombok.Getter;

@Getter
public class ErrorMessageDto extends ResponseDto{
    String message;

    public ErrorMessageDto(String message) {
        super.result = "fail";
        this.message = message;
    }
}
