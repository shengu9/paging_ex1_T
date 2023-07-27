package org.spring.pagingpj.service;

import lombok.RequiredArgsConstructor;
import org.spring.pagingpj.dto.BoardDto;
import org.spring.pagingpj.entity.BoardEntity;
import org.spring.pagingpj.repository.BoardRepository;
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
}
