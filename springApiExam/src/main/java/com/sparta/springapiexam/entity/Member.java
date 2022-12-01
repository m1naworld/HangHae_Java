package com.sparta.springapiexam.entity;

import com.sparta.springapiexam.dto.MemberResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String pw;

    public Member(MemberResponseDto memberResponseDto) {
        this.name = memberResponseDto.getName();
        this.email = memberResponseDto.getEmail();
        this.pw = memberResponseDto.getPw();
    }


}
