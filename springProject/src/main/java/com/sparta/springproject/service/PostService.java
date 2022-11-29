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
    public ResponsePostingDto registerPost(PostingDto postDto) {
        Posting posting = new Posting(postDto);
        postingRepository.save(posting);

        return new ResponsePostingDto(posting);
    }


    // 게시글 비밀번호 확인 로직
    private Map<String, Object> checkPassword(Long id, String password) {
        Map<String, Object> map = new HashMap<>();

        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );

        if (posting.getPostPassword().equals(password)) {
            map.put("result", "success");
            map.put("postingEntity", posting);
        } else {
            map.put("result", "fail");
        }

        return map;
    }

    
    //게시글 수정
    public Map<String, Object> updatePost(Long id, PostingDto postingDto) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> checkPost = checkPassword(id, postingDto.getPostPassword());

        if(checkPost.get("result").equals("success")){
            Posting posting = (Posting) checkPost.get("postingEntity");
            posting.update(postingDto);
            ResponsePostingDto responsePostingDto = new ResponsePostingDto(posting);
            map.put("message", "게시글 수정 완료!");
            map.put("result", "success");
            map.put("responsePostingDto", responsePostingDto);
        }else{
            map.put("message", "비밀번호가 일치하지 않습니다.");
            map.put("result", "fail");
        }
        return map;
    }
}
