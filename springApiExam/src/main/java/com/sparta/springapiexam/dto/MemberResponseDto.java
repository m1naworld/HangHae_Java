package com.sparta.springapiexam.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto extends ResponseDto{
    private final MemberDto memberDto;

    public MemberResponseDto(int statusCode, String message, MemberDto memberDto) {
        super (statusCode , message);
        this.memberDto = memberDto;
    }
}