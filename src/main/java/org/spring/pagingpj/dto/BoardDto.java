package org.spring.pagingpj.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.spring.pagingpj.entity.BoardEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardDto {

   private Long id;

  private String boardTitle;

  private String boardContent;

  private String boardWriter;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;

  public BoardDto(Long id, String boardWriter, String boardTitle, String boardContent) {
    this.id=id;
    this.boardWriter=boardWriter;
    this.boardContent=boardContent;
    this.boardTitle=boardTitle;
  }

  // Entity -DTO
  public static BoardDto toBoardDto(BoardEntity boardEntity) {

    BoardDto boardDto=new BoardDto();
    boardDto.setId(boardEntity.getId());
    boardDto.setBoardTitle(boardEntity.getBoardTitle());
    boardDto.setBoardContent(boardEntity.getBoardContent());
    boardDto.setBoardWriter(boardEntity.getBoardWriter());
    boardDto.setCreateTime(boardEntity.getCreateTime());
    boardDto.setUpdateTime(boardEntity.getUpdateTime());

    return boardDto;
  }
}
