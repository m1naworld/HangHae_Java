package com.sparta.springapiexam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ResponseDto {

    protected int statusCode;
    protected String message;
}
