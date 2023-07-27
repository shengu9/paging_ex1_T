package org.spring.pagingpj.controller;

import org.spring.pagingpj.dto.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Controller+@ResponseBody -> 값만 return
@RequestMapping("/api")
public class RestApiController {
  @GetMapping("/ajax1")
  public String ajax1(){
    return "반환된는 값-> ajax1";
  }
  @GetMapping("/ajax2")  // @RestController
  public String ajax2(){

    BoardDto boardDto=new BoardDto();
    boardDto.setBoardTitle("제목");
    boardDto.setBoardContent("내용");
    boardDto.setBoardWriter("작성자");

    return boardDto.toString();
  }












}
