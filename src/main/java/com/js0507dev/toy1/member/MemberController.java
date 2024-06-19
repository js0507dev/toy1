package com.js0507dev.toy1.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
  @Cacheable(value = "Member", key = "#id")
  public ResponseEntity<MemberDto> findById(@PathVariable Long id) {
    Member found = this.memberService.getById(id);
    return ResponseEntity.ok(MemberDto.from(found));
  }

  @PutMapping("{id}")
  @CachePut(value = "Member", key = "#id")
  public ResponseEntity<MemberDto> updateById(@PathVariable Long id, @RequestBody UpdateMemberReqDto dto) {
    Member updated = this.memberService.updateById(id, dto);
    return ResponseEntity.ok(MemberDto.from(updated));
  }

  @DeleteMapping("{id}")
  @CacheEvict(value = "Member", key = "#id")
  public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
    Boolean deleted = this.memberService.deleteById(id);
    return ResponseEntity.ok(deleted);
  }
}
