package com.js0507dev.toy1.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MemberService {
  private MemberRepository memberRepository;

  @Autowired
  public void setMemberRepository(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Optional<Member> findById(Long id) {
    return this.memberRepository.findById(id);
  }

  public Member getById(Long id) {
    return this.findById(id).orElseThrow(); // TODO: throw not found exception
  }

  public Member updateById(Long id, UpdateMemberReqDto dto) {
    Member target = this.getById(id);
    target.setName(dto.getName());
    target.setEmail(dto.getEmail());

    try {
      return this.memberRepository.save(target);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Boolean deleteById(Long id) {
    try {
      this.memberRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
