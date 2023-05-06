package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.example.thboard.service.BoardService;
import study.example.thboard.service.UserService;
import study.example.thboard.vo.BoardVo;
import study.example.thboard.vo.UserVo;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/")
public class MainController {

    private final BoardService boardService;

    /**
     * 게시글 목록 조회
     * @return
     */
    @GetMapping(value = "")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView("pages/index");
        List<BoardVo> boardList = null;

        try {
            boardList = boardService.getBoards();
            mv.addObject("list", boardList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

     /**
     * 게시글 작성 폼
     * @return
     */
    @GetMapping("regForm")
    public ModelAndView regForm() {
        ModelAndView mv = new ModelAndView("pages/reg");
        mv.addObject("board", new BoardVo());
        return mv;
    }

    /**
     * 게시글 등록 처리
     * @param boardVo
     * @return
     */
    @PostMapping("reg")
    public String reg(@ModelAttribute BoardVo boardVo) {
        try {
            boardService.regBoard(boardVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/board";
    }

    /**
     * 게시글 상세
     * @param boardNo
     * @return
     */
    @GetMapping("detail")
    public ModelAndView detail(@RequestParam int boardNo) {
        ModelAndView mv = new ModelAndView("pages/detail");
        try {
            BoardVo info = boardService.getBoard(boardNo);
            mv.addObject("info", info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 게시글 수정
     * @param boardVo
     * @return
     */
    @PostMapping("modify")
    public String modify(@ModelAttribute BoardVo boardVo) {
        try {
            boardService.modifyBoard(boardVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/board";
    }


}
