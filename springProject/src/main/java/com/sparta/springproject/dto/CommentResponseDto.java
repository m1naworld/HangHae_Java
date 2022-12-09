package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto extends ResponseDto {

    private CommentDto commentDto;

    public CommentResponseDto(CommentDto commentDto) {
        super.result = "success";
        this.commentDto = commentDto;
    }
}
