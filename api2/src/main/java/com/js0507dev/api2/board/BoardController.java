package com.js0507dev.api2.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/boards")
public class BoardController {
  private final BoardService boardService;

  @Autowired
  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("")
  public ResponseEntity<List<BoardDto>> findAll() {
    List<BoardDto> result = StreamSupport
        .stream(boardService
            .getAllBoards()
            .spliterator(), false)
        .map(BoardDto::from)
        .toList();
    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BoardDto> findOne(@PathVariable Long id) {
    return ResponseEntity.ok(BoardDto.from(boardService.getBoardById(id)));
  }

  @PostMapping("")
  public ResponseEntity<BoardDto> createOne(@RequestBody CreateOrUpdateBoardReqDto dto) {
    return ResponseEntity.ok(BoardDto.from(boardService.createBoard(dto)));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateOne(@PathVariable Long id, @RequestBody CreateOrUpdateBoardReqDto dto) {
    boardService.updateBoard(id, dto);
    return ResponseEntity
        .noContent()
        .build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOne(@PathVariable Long id) {
    boardService.deleteBoardById(id);
    return ResponseEntity
        .noContent()
        .build();
  }
}
