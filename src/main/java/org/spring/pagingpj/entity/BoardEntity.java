package org.spring.pagingpj.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
  private LocalDateTime updateTiem;


}
