package com.sparta.springapiexam.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto extends ResponseDto{
    private final MemberDto memberDto;

    public MemberResponseDto(String message, MemberDto memberDto) {
        super (message);
        this.memberDto = memberDto;
    }
}