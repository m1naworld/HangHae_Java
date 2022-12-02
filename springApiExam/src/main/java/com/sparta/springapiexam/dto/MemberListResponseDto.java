package com.sparta.springapiexam.dto;

import java.util.List;

public class MemberListResponseDto extends ResponseDto {

    private List<MemberDto> members;

    public MemberListResponseDto(String message, List<MemberDto> members) {
        super(message);
        this.members = members;
    }
}
