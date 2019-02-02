package my.examples.springjdbc.service;

import my.examples.springjdbc.dto.Board;

import java.util.List;

public interface BoardService {
    List<Board> getBoards(int page);
    Board getBoard(Long id);
    void deleteBoard(Long id);
    Board addBoard(Board board);
    void addReBoard(Board board);

}