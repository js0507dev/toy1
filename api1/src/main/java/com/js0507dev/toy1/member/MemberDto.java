package com.js0507dev.toy1.member;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
  private Long id;
  private String name;
  private String email;

  public MemberDto(Member member) {
    this.id = member.getId();
    this.name = member.getName();
    this.email = member.getEmail();
  }

  public static MemberDto from(Member member) {
    return new MemberDto(member);
  }
}
