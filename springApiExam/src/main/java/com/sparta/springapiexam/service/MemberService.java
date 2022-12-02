package com.sparta.springapiexam.service;

import com.sparta.springapiexam.dto.MemberDto;
import com.sparta.springapiexam.entity.Member;
import com.sparta.springapiexam.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberDto findMember(Long id) {
            Member member = memberRepository.findById(id).orElseThrow(() -> new NullPointerException("No User Found"));
           return new MemberDto(member);

    }

    public List<MemberDto> findAllMember() {
       List<Member> members = memberRepository.findAll();

       List<MemberDto> memberResponseDtoList = new ArrayList<>();

       for(Member m : members){
           MemberDto memberToDto = new MemberDto(m);
           memberResponseDtoList.add(memberToDto);
       }

       if(memberResponseDtoList.isEmpty()){
           throw new NullPointerException("No User Found");
       }

       return memberResponseDtoList;
    }
}