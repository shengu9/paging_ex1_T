package org.spring.pagingpj.controller;

import lombok.RequiredArgsConstructor;
import org.spring.pagingpj.dto.BoardDto;
import org.spring.pagingpj.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

//  @Autowired
//  private BoardService boardService;

  private final BoardService boardService;

  @GetMapping("/boardList")
  public String boardList(Model model){

    List<BoardDto> boardList= boardService.boardListDo();

    model.addAttribute("boardList",boardList);

    return "board/boardList";
  }

  @GetMapping("/pagingList")
  public String pagingList(){

    return "board/pagingList";
  }









}
