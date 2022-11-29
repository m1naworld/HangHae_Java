package com.sparta.springproject.service;

import com.sparta.springproject.dto.PostingDto;
import com.sparta.springproject.dto.ResponseDto;
import com.sparta.springproject.dto.ResponsePostingDto;
import com.sparta.springproject.entity.Posting;
import com.sparta.springproject.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostingRepository postingRepository;


    // 게시글 등록
    public ResponsePostingDto registerPost(PostingDto postDto){
        Posting posting  = new Posting(postDto);
        postingRepository.save(posting);

        return new ResponsePostingDto(posting);
    }




}
