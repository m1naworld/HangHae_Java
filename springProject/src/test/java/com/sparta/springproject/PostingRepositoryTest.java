package com.sparta.springproject;

import com.sparta.springproject.dto.PostingRequestDto;
import com.sparta.springproject.entity.Posting;
import com.sparta.springproject.repository.PostingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
public class PostingRepositoryTest {

    @Autowired
    PostingRepository postingRepository;

    // 시간 생성 Test
    @Test
    void checkPostPosting(){
        // 영속성 컨텍스트 -> 모은 쿼리들을 한번에 mock객체, mockito 찾아보기 >> jpa와 별개인 테스트 상황
        PostingRequestDto myPostDto = new PostingRequestDto("취업", "미나냐", "1234", "취뽀하고싶다!");

        Posting posing  = new Posting(myPostDto);
        System.out.println("DB 저장 전 게시글 생성 시간: " + posing.getCreatedAt());

        postingRepository.save(posing);
        System.out.println("DB 저장 후 게시글 생성 시간: " + posing.getCreatedAt());

        List<Posting> myPostDto1 = postingRepository.findAll();
        LocalDateTime saveTime = myPostDto1.get(0).getCreatedAt();
        System.out.println("디비에 저장된 게시글 생성 시간: " + saveTime);

    }

    // 비밀번호 확인
    @Test
    void checkPassword() throws Throwable {

        // given
        PostingRequestDto myPostDto = new PostingRequestDto("취업", "미나냐", "1234", "취뽀하고싶다!");
        Posting posing  = new Posting(myPostDto);
        postingRepository.save(posing);


        // when
        Long id = 1L;
        String password = "1234";


        // then
        Posting result = (Posting) postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );

        if(!result.getPostPassword().equals(password)){
            System.out.println("비밀번호 확인 결과: " + false);
        }else{
            System.out.println("비밀번호 확인 결과: " + true);
        }



    }

}
