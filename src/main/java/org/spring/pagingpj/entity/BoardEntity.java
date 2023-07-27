package org.spring.pagingpj.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.spring.pagingpj.dto.BoardDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "paging_tb_1")
public class BoardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String boardTitle;

  @Column(nullable = false)
  private String boardContent;

  @Column(nullable = false)
  private String boardWriter;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createTime;

  @CreationTimestamp
  @Column(insertable = false)
  private LocalDateTime updateTime;

  // 기본 생성자 ->Dto -Entity
  public static BoardEntity toBoardEntity(BoardDto boardDto) {
    BoardEntity boardEntity=new BoardEntity();
    boardEntity.setBoardWriter(boardDto.getBoardWriter());
    boardEntity.setBoardTitle(boardDto.getBoardTitle());
    boardEntity.setBoardContent(boardDto.getBoardContent());
    return boardEntity;
  }


}
