package com.sparta.springapiexam.dto;

import java.util.List;

public class MemberListResponseDto extends ResponseDto {

    private List<MemberDto> members;

    public MemberListResponseDto(int statusCode, String message, List<MemberDto> members) {
        super(statusCode, message);
        this.members = members;
    }
}
