package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostingListResponseDto extends ResponseDto{
    private List<PostingDto> postingListDto;

    public PostingListResponseDto(String result, String message, List<PostingDto> postingListDto) {
        super(result, message);
        this.postingListDto = postingListDto;
    }
}
