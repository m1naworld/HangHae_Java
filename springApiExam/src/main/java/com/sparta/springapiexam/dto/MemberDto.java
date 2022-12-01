package com.sparta.springapiexam.dto;

import com.sparta.springapiexam.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private String name;
    private String email;
    private String pw;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.pw = member.getPw();
    }
}
