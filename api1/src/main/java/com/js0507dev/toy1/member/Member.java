package com.js0507dev.toy1.member;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners({AuditingEntityListener.class})
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String email;
  @CreatedDate
  private Date createdAt;
  @LastModifiedDate
  private Date updatedAt;

  public Member(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
