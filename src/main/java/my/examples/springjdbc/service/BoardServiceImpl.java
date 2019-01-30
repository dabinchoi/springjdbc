package my.examples.springjdbc.service;


import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dao.BoardDaoImpl;
import my.examples.springjdbc.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private BoardDao boardDao;
    public static final int SIZE = 3;

    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(int page) {
     //   BoardDao boardDao = new BoardDaoImpl();
        int start = page * SIZE -SIZE;
        int limit = SIZE;

        List<Board> boards = new ArrayList<>();

        return boards;
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {
        Board board = null;
        Connection conn = null;

        return board;
    }


    @Override
    public void deleteBoard(Long id) {
        Connection conn = null;
        //BoardDao boardDao = new BoardDaoImpl();

    }

    @Override
    public void addBoard(Board board) {
        Connection conn = null;
     //   BoardDao boardDao = new BoardDaoImpl();

    }


    @Override
    public void addReBoard(Board board) {
        Connection conn = null;
      //  BoardDao boardDao = new BoardDaoImpl();

    }
}