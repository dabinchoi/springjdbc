package my.examples.springjdbc.controller;

import my.examples.springjdbc.dto.Board;
import my.examples.springjdbc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {
    BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }
    @GetMapping("/board")
    public String main(
            @RequestParam(name="page" , required = false, defaultValue = "1")int page,
                        Model model){
   /*     List<Board> boards = boardService.getBoards(page);*/
/*        model.addAttribute("boards",boards);*/
        return "board";

    }
    @GetMapping("/boardform")
    public String boardform(){
        return "boardform";
    }
    @PostMapping("/board")
    public String board(@RequestParam(name = "name") String name,
                        @RequestParam(name = "nickname") String nickname,
                        @RequestParam(name = "email") String email,
                        @RequestParam(name = "passwd") String passwd,
                        @RequestHeader(name = "Accept") String accept,
                        HttpSession session) {
        Assert.hasLength(name,"입력하라고 ㅡㅡㅡ");


        return "redirect:/board";
    }

}
