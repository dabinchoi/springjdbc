package my.examples.springjdbc.service;

import my.examples.springjdbc.dto.Board;

import java.util.List;

public interface BoardService {
    public List<Board> getBoards(int page);
    public Board getBoard(Long id);
    public void deleteBoard(Long id);

    void addBoard(Board board);

    void addReBoard(Board board);
}