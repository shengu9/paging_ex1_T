package org.spring.pagingpj.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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


}
