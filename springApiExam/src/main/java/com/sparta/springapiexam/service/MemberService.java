package com.sparta.springapiexam.service;

import com.sparta.springapiexam.dto.MemberResponseDto;
import com.sparta.springapiexam.entity.Member;
import com.sparta.springapiexam.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new NullPointerException("회원 상세 조회 실패"));
        return new MemberResponseDto(member);
    }

    public List<MemberResponseDto> findAllMember() {
       List<Member> members = memberRepository.findAll();

       List<MemberResponseDto> memberResponseDtoList = new ArrayList<>();

       for(Member m : members){
           MemberResponseDto memberToDto = new MemberResponseDto(m);
           memberResponseDtoList.add(memberToDto);
       }

       return memberResponseDtoList;
    }
}