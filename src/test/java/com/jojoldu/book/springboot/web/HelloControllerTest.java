package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)//JUnit에 내장된 실행자 외에 다른 실행자를 실행, SpringRunner가 실행자임. 즉, 스프링부트테스트와 JUnit을 연결해줌.
@WebMvcTest//Business컴포넌트를 제외한 기능 @Controller , @ControllerAdvice를 사용할 수 있음.
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;//웹API를 테스트할 때 사용함. SpringMVC의 시작점임. 이 것을 통해 HTTP get,post API를 테스트할 수 있음.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello"))//"/hello"요청을 발생시킨다.
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void hello_dto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
        //응답객체인 json의 필드값 :  $.필드명
    }

}
