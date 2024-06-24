package com.js0507dev.toy1.member;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UpdateMemberReqDto {
  private String name;
  private String email;
}
