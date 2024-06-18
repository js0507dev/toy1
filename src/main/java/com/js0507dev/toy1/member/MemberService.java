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

  // TODO: throw NotFoundException
  public Member getById(Long id) {
    return this.memberRepository
        .findById(id).orElseThrow();
  }
}
