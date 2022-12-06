package com.sparta.springproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto extends ResponseDto {

    private CommentDto commentDto;

    public CommentResponseDto(String result, String message, CommentDto commentDto) {
        super(result, message);
        this.commentDto = commentDto;
    }
}
