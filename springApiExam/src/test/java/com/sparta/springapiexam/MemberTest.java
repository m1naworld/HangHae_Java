package com.sparta.springapiexam;


import com.sparta.springapiexam.dto.MemberDto;
import com.sparta.springapiexam.entity.Member;
import com.sparta.springapiexam.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;


@DataJpaTest
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;



    @Test
    @Transactional
    void insertMember(){

        //given : 선행조건 기술
        MemberDto member1= new MemberDto(1L, "윤지용", "jyyoon@naver.com", "1234");
        MemberDto member2 = new MemberDto(2L, "손윤주", "yjson@naver.com", "3421");

        //when : 기능 수행
        memberRepository.save(new Member(member1));
        memberRepository.save(new Member(member2));

//        //then : 결과 확인
        List<Member> members = memberRepository.findAll();

        for(int i=0; i < members.size(); i++){
            System.out.println(members.get(i).getId() + " " +  members.get(i).getName());
        }

        Long id1 = 1L;
        Member findMember1= memberRepository.findById(id1).orElseThrow(() -> new NullPointerException("회원 상세 조회 실패"));
        System.out.println("회원 조회 성공: " + findMember1.getName());

        // NullPointerException 에러 뜨는지 확인
        Long id2 = 3L;
        Member findmember2 = memberRepository.findById(id2).orElseThrow(() -> new NullPointerException("회원 상세 조회 실패"));

    }



}
