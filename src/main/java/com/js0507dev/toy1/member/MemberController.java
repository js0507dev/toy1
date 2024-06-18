package com.js0507dev.toy1.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/members/")
public class MemberController {
  private MemberService memberService;

  @Autowired
  public void setMemberService(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("{id}")
  public ResponseEntity<MemberDto> findById(@PathVariable Long id) {
    Member found = this.memberService.getById(id);
    return ResponseEntity.ok(MemberDto.from(found));
  }
}
