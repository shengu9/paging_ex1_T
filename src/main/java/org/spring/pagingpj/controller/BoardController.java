package org.spring.pagingpj.controller;

import lombok.RequiredArgsConstructor;
import org.spring.pagingpj.dto.BoardDto;
import org.spring.pagingpj.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

  //    /paingList?page=0&size=6
  @GetMapping("/pagingList")  // page=0 -> DB     // 페이지수, 한페이지 보이는View수 , 정렬
  public String pagingList(@PageableDefault(page = 0, size = 3,sort = "id",
                              direction = Sort.Direction.DESC) Pageable pageable,Model model){
   // *** Page<>  Pageable
   Page<BoardDto> boardList= boardService.boardPagingList(pageable);

   long totalCount= boardList.getTotalElements();

   int pageSize= boardList.getSize();


    // 총 글수 17
    // 한페이지 당 size 3
    // 총페이수 6
    // blockNum=3
    //1  2  3    -> 3 3 3
    //4  5  6    -> 3 3 2
    // 블록의 첫페지이 지
    // 블록이 3일 경우     123 -> 1, 456  -> 4 , 789 -> 7
    int nowPage=boardList.getNumber(); // //현재페이지
    int totalPage= boardList.getTotalPages();// 총페이지수
    int blockNum=3;//

    // Math.floor -> 올림
    int startPage =
            (int)((Math.floor(nowPage/blockNum)*blockNum)+1 <= totalPage ? (Math.floor(nowPage/blockNum)*blockNum)+1 : totalPage);
    // 블록의 마지막 페이지
    // 블록이 3일 경우      123 -> 3, 456  -> 5 , 789 -> 9
    // 시작페이지+블록-1> 전체 페이지 -> 마지막페이지숫자(시작페이지+블록-1)
    int endPage = (startPage + blockNum-1 < totalPage ? startPage + blockNum-1 : totalPage);

    for(int i=startPage;i<=endPage;i++){
      System.out.print(i+" , ");
    }

   model.addAttribute("startPage", startPage);
   model.addAttribute("endPage", endPage);
   model.addAttribute("boardList",boardList);

    return "board/pagingList";
  }









}
