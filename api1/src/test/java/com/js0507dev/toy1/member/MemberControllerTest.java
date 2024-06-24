package com.js0507dev.toy1.member;

import com.js0507dev.toy1.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class MemberControllerTest {
  @InjectMocks
  private MemberController memberController;
  @Mock
  private MemberService memberService;

  @Nested
  class FindByIdTest {
    @Test
    @DisplayName("success")
    void givenId_whenFindById_thenReturnMemberDTO() {
      // given
      Long memberId = 1L;
      Member mocked = Member
          .builder()
          .id(memberId)
          .build();

      // when
      when(memberService.getById(anyLong())).thenReturn(mocked);
      ResponseEntity<MemberDto> found = memberController.findById(memberId);

      // then
      assertEquals(HttpStatus.OK, found.getStatusCode());
      assertEquals(memberId, Objects
          .requireNonNull(found.getBody())
          .getId());
    }

    @Test
    @DisplayName("[fail]: NotFoundException")
    void givenId_whenFindById_thenThrowNotFoundException() {
      // given
      Long memberId = 1L;

      // when
      doThrow(new NotFoundException("")).when(memberService).getById(anyLong());

      // then
      assertThrows(NotFoundException.class, () -> memberController.findById(memberId));
    }
  }

  @Nested
  class UpdateByIdTest {
    @Test
    @DisplayName("success")
    void givenId_whenUpdateById_thenReturnUpdated() {
      // given
      Long memberId = 1L;
      String updateName = "name1";
      String updateEmail = "email1@email.com";

      // when
      UpdateMemberReqDto updateDto = UpdateMemberReqDto
          .builder()
          .name(updateName)
          .email(updateEmail)
          .build();
      ResponseEntity<Void> found = memberController.updateById(memberId, updateDto);

      // then
      assertEquals(HttpStatus.NO_CONTENT, found.getStatusCode());
    }

    @Test
    @DisplayName("[fail]: NotFoundException")
    void givenId_whenUpdateById_thenThrowNotFoundException() {
      // given
      Long memberId = 1L;
      UpdateMemberReqDto dto = UpdateMemberReqDto
          .builder()
          .name("test")
          .build();

      // when
      doThrow(new NotFoundException("")).when(memberService).updateById(memberId, dto);

      // then
      assertThrows(NotFoundException.class, () -> memberController.updateById(memberId, dto));
    }
  }

  @Nested
  class DeleteByIdTest {
    @Test
    @DisplayName("success")
    void givenId_whenDeleteById_thenReturnEmptyBody() {
      // given
      Long memberId = 1L;

      // when
      ResponseEntity<Void> res = memberController.deleteById(memberId);

      // then
      assertEquals(HttpStatus.NO_CONTENT, res.getStatusCode());
    }

    @Test
    @DisplayName("[fail]: NotFoundException")
    void givenId_whenDeleteById_thenThrowNotFoundException() {
      // given
      Long memberId = 1L;

      // when
      doThrow(new NotFoundException("")).when(memberService).deleteById(memberId);

      // then
      assertThrows(NotFoundException.class, () -> memberController.deleteById(memberId));
    }
  }
}
