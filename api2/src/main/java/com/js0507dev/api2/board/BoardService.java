package com.js0507dev.api2.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BoardService {
  private final BoardRepository boardRepository;

  @Autowired
  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public Iterable<Board> getAllBoards() {
    return boardRepository.findAll();
  }

  public Optional<Board> findBoardById(Long id) {
    return boardRepository.findById(id);
  }

  public Board getBoardById(Long id) {
    return this
        .findBoardById(id)
        .orElseThrow(NoSuchElementException::new);
  }

  public Board createBoard(CreateOrUpdateBoardReqDto dto) {
    Board board = dto.toBoard();
    return boardRepository.save(board);
  }

  public void updateBoard(Long id, CreateOrUpdateBoardReqDto dto)/* throws NoPermissionException */{
    Board board = this.getBoardById(id);

    // TODO: Permission
//    if (board.getCreatorId() != dto.getCreatorId()) {
//      throw new NoPermissionException();
//    }

    board.setTitle(dto.getTitle());
    board.setDescription(dto.getDescription());
    boardRepository.save(board);
  }

  public void deleteBoardById(Long id) {
    Board board = this.getBoardById(id);
    // TODO: Permission

    boardRepository.delete(board);
  }
}
