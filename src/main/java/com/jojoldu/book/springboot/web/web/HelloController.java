package com.jojoldu.book.springboot.web.web;

import com.jojoldu.book.springboot.web.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello") //@RequestMapping(method = RequestMethod.GET)을 대체함
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name")String name, @RequestParam("amount")int amount){
        return new HelloResponseDto(name, amount);
    }

}
