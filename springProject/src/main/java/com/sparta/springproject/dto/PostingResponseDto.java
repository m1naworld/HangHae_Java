package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostingResponseDto extends ResponseDto{

    private PostingDto postingDto;

    public PostingResponseDto(PostingDto postingDto) {
        super.result = "success";
        this.postingDto = postingDto;
    }
}
