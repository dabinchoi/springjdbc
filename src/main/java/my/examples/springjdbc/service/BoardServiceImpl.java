package my.examples.springjdbc.service;

import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDao boardDao;


    @Override
    @Transactional(readOnly = true)
    public List<Board> selectAllBoards(int start, int limit) {
        return boardDao.getBoards(0,5);
    }

    @Override
    @Transactional(readOnly = true)
    public Board selectBoard(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> searchBoards(String option, String keyword) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public int selectAllCount() {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public long selectSearchCount(String subject, String keyword) {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public long getTotalPage(int boardCount, int list) {
        return 0;
    }

    @Override
    public long addBoard(Board board) {
        return 0;
    }

    @Override
    public long updateBoard(Long id, String title, String content) {
        return 0;
    }

    @Override
    public long deleteBoard(Long id) {
        return 0;
    }
}