package com.js0507dev.api2.board;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Builder
@EntityListeners({AuditingEntityListener.class})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String description;
  private Long creatorId;
  @CreatedDate
  private Date createdAt;
  @LastModifiedDate
  private Date updatedAt;

  public Board(String title, String description, Long creatorId) {
    this.title = title;
    this.description = description;
    this.creatorId = creatorId;
  }
}
