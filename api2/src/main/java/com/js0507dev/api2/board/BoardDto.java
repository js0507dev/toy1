package com.js0507dev.api2.board;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
  private Long id;
  private String title;
  private String description;
  private Long creatorId;
  private Date createdAt;
  private Date updatedAt;

  public BoardDto(Board board) {
    this.id = board.getId();
    this.title = board.getTitle();
    this.description = board.getDescription();
    this.creatorId = board.getCreatorId();
    this.createdAt = board.getCreatedAt();
    this.updatedAt = board.getUpdatedAt();
  }

  public static BoardDto from(Board board) {
    return new BoardDto(board);
  }
}
