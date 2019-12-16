package com.jojoldu.book.springboot.web.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;

    //생성자 함수를 어노테이션으로 교체

    //get메소드를 어노테이션으로 교체
}
