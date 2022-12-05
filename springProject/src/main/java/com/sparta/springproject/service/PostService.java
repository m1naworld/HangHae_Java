package com.sparta.springproject.service;

import com.sparta.springproject.dto.PostingRequestDto;
import com.sparta.springproject.dto.PostingResponseDto;
import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.dto.PostingDto;
import com.sparta.springproject.entity.Posting;
import com.sparta.springproject.repository.PostingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostingRepository postingRepository;


    // 하나의 게시글 반환
    @Transactional
    public PostingDto findOnePost(Long id)  {
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        return new PostingDto(posting);
    }

    // 모든 게시글 반환
    @Transactional
    public List<PostingDto> findAllPost() {
        List<Posting> postings = postingRepository.findAll();
        List<PostingDto> result = new ArrayList<>();

        for (Posting p : postings) {
            result.add(new PostingDto(p));
        }

        return result;
    }


    // 게시글 등록
    @Transactional
    public PostingDto registerPost(PostingRequestDto postingRequestDto) {
        Posting posting = new Posting(postingRequestDto);
        postingRepository.save(posting);

        return new PostingDto(posting);
    }


    // 게시글 비밀번호 확인 로직
    private Posting checkPassword(Long id, String password) {
        Posting posting = postingRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        if (posting.getPostPassword().equals(password)) {
            return posting;
        } else {
            return new Posting();
        }
    }


    //게시글 수정
    @Transactional
    public ResponseDto updatePost(Long id, PostingRequestDto postingDto) {
        Posting posting = checkPassword(id, postingDto.getPostPassword());

        if (posting.getId() != null) {
            posting.update(postingDto);
            PostingDto responsePostingDto = new PostingDto(posting);
            return new PostingResponseDto("게시글 수정 완료!", "success", responsePostingDto);
        } else {
            return new ResponseDto("비밀번호가 일치하지 않습니다.", "fail");
        }
    }


    // 게시글 삭제
    @Transactional
    public ResponseDto deletePost(Long id, String password) {

        Posting checkPost = checkPassword(id, password);

        if (checkPost.getId() != null) {
            postingRepository.deleteById(id);
            return new ResponseDto("게시글 삭제 완료!", "success");
        } else {
            return new ResponseDto("비밀번호가 일치하지 않습니다.", "fail");
        }

    }
}
