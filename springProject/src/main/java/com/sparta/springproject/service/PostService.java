package com.sparta.springproject.service;

import com.sparta.springproject.dto.PostingRequestDto;
import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.dto.PostingResponseDto;
import com.sparta.springproject.entity.Posting;
import com.sparta.springproject.repository.PostingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostingRepository postingRepository;


    // 하나의 게시글 반환
    @Transactional
    public PostingResponseDto findOnePost(Long id) throws Throwable {
        Posting posting = (Posting) postingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        return  new PostingResponseDto(posting);
    }

    // 모든 게시글 반환
    @Transactional
    public List<PostingResponseDto> findAllPost(){
        List<Posting> postings = postingRepository.findAll();

        List<PostingResponseDto> result = new ArrayList<>();

        for(Posting p : postings){
            result.add(new PostingResponseDto(p));
        }

        return result;
    }


    // 게시글 등록
    @Transactional
    public PostingResponseDto registerPost(PostingRequestDto postDto) {
        Posting posting = new Posting(postDto);
        postingRepository.save(posting);

        return new PostingResponseDto(posting);
    }


    // 게시글 비밀번호 확인 로직

    private ResponseDto checkPassword(Long id, String password)  {
        try {
            Posting posting = (Posting) postingRepository.findById(id).orElseThrow();

            if (posting.getPostPassword().equals(password)) {
                return new ResponseDto(null, "success", new PostingResponseDto(posting));
            } else {
                return new ResponseDto(null, "fail", null);
            }
        } catch (IllegalArgumentException e){
            return new ResponseDto("게시글이 존재하지 않습니다.", "fail", null);
        }

    }


    //게시글 수정
    @Transactional
    public ResponseDto updatePost(Long id, PostingRequestDto postingDto){
        ResponseDto checkPost = checkPassword(id, postingDto.getPostPassword());

        if(checkPost.getResult().equals("success")){
            Posting posting = new Posting(checkPost.getResponsePostingDto());
            posting.update(postingDto);
            PostingResponseDto responsePostingDto = new PostingResponseDto(posting);

            return new ResponseDto("게시글 수정 완료!", "success", responsePostingDto);
        }else{
          return new ResponseDto("비밀번호가 일치하지 않습니다.", "fail", null);
        }
    }


    // 게시글 삭제
    @Transactional
    public ResponseDto deletePost(Long id, String password)  {

        ResponseDto checkPost = checkPassword(id, password);

        Map<String, Object> map = new HashMap<>();
        if(checkPost.getResult().equals("success")){
            postingRepository.deleteById(id);
            return new ResponseDto("게시글 삭제 완료!", "success", null);
        }else{
            return new ResponseDto("비밀번호가 일치하지 않습니다.", "fail", null);
        }

    }
}
