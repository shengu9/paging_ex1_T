package org.spring.pagingpj.service;

import lombok.RequiredArgsConstructor;
import org.spring.pagingpj.dto.BoardDto;
import org.spring.pagingpj.entity.BoardEntity;
import org.spring.pagingpj.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public List<BoardDto> boardListDo() {

    List<BoardDto> boardDtoList = new ArrayList<>();
    List<BoardEntity> boardEntityList = boardRepository.findAll();

    for (BoardEntity boardEntity : boardEntityList) {
      BoardDto boardDto = BoardDto.toBoardDto(boardEntity);
      boardDtoList.add(boardDto);
    }

    return boardDtoList;

  }

  public Page<BoardDto> boardListPaging(Pageable pageable) {
    Page<BoardEntity> boardEntities = boardRepository.findAll(pageable);

    Page<BoardDto> boardDtos = boardEntities.map(BoardDto::toBoardDto);

    return boardDtos;
  }

  public Page<BoardDto> boardPagingList(Pageable pageable) {
    Page<BoardEntity> boardEntities = boardRepository.findAll(pageable);
//    boardEntities.map(board ->new BoardDto(board.getId(),board.getBoardContent(),))

    int nowPage= boardEntities.getNumber();// 요처 페이지 번호
    long totalCount= boardEntities.getTotalElements();// 전체게시글수
    int totalPage= boardEntities.getTotalPages();// 전체 페이지갯수
    int pageSize=  boardEntities.getSize();    // 한페이지에 보이는 개수
    boardEntities.isFirst();// 첫번째 페이지냐?
    boardEntities.isLast();// 마지막 페이지냐?
    boardEntities.hasPrevious();// 이전페이자 있느냐?
    boardEntities.hasNext();// 다음페이자 있느냐?


    System.out.println(totalCount+" 총글수");
    System.out.println(totalPage+" 총페이지");
    System.out.println(pageSize+" 페이지당글수");
    System.out.println(nowPage+" 현재페이지");


    //Entity-> Dto
    Page<BoardDto> boardDtos = boardEntities.map(BoardDto::toBoardDto);
    return boardDtos;
//    return boardRepository.findAll(pageable).map(BoardDto::toBoardDto);;

  }
}
