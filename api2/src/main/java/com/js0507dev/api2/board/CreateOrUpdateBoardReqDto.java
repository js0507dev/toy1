package com.js0507dev.api2.board;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateOrUpdateBoardReqDto {
  private String title;
  private String description;
  private Long creatorId;

  public Board toBoard() {
    return Board
        .builder()
        .title(title)
        .description(description)
        .creatorId(creatorId)
        .build();
  }
}
