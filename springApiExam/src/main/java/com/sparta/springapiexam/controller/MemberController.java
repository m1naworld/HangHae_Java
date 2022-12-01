package com.sparta.springapiexam.controller;

import com.sparta.springapiexam.dto.MemberDto;
import com.sparta.springapiexam.dto.MemberListResponseDto;
import com.sparta.springapiexam.dto.MemberResponseDto;
import com.sparta.springapiexam.dto.ResponseDto;
import com.sparta.springapiexam.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{id}")
    public ResponseDto getMemberInfo(@PathVariable Long id) {

        try {
            MemberDto memberDto = memberService.findMember(id);
            return new MemberResponseDto(200, "회원 조회 성공", memberDto);
        } catch (NullPointerException e) {
            return new ResponseDto(200, "존재하지 않는 회원");
        }
    }

    @GetMapping("/member")
    public ResponseDto getMemberList() {

        try {
            List<MemberDto> members = memberService.findAllMember();
            return new MemberListResponseDto(200, "회원 전체 조회", members);
        } catch (NullPointerException e) {
            return new ResponseDto(200, "존재하는 회원 업음");
        }
    }

}
