package com.js0507dev.toy1.member;

import com.js0507dev.toy1.exception.NotFoundException;
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
    return this.findById(id).orElseThrow(() -> new NotFoundException("Member not found. Id: " + id));
  }

  public Member updateById(Long id, UpdateMemberReqDto dto) {
    Member target = this.getById(id);
    target.setName(dto.getName());
    target.setEmail(dto.getEmail());

    return this.memberRepository.save(target);
  }

  public void deleteById(Long id) {
    if (this.findById(id).isEmpty()) {
      throw new NotFoundException("Member not found. Id: " + id);
    }
    this.memberRepository.deleteById(id);
  }
}
