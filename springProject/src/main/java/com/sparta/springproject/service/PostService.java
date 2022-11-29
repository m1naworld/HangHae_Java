package com.sparta.springproject.service;

import com.sparta.springproject.dto.PostingDto;
import com.sparta.springproject.entity.Posting;
import com.sparta.springproject.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostingRepository postingRepository;


    // 게시글 등록
    public Map<String, Object> registerPost(PostingDto myPostDto){
        Map<String, Object> result = new HashMap<>();

        Posting posing  = new Posting(myPostDto);
        postingRepository.save(posing);

        result.put("result", "success");
        result.put("message", "게시글 등록 완료!");

        return result;
    }


}
