package com.js0507dev.api2.board;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
  List<Board> findByTitleLike(String title);
  List<Board> findByCreatorId(Long creatorId);
}
