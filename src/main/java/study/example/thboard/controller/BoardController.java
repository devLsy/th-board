package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.example.thboard.service.BoardService;
import study.example.thboard.vo.BoardVo;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/board")
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 목록 조회
     * @return
     */
    @GetMapping("")
    public ModelAndView list() {

        ModelAndView mv = new ModelAndView("pages/board");
        List<BoardVo> boardList = null;

        try {
            boardList = boardService.getBoards();
        } catch (Exception e) {
            log.debug("Exception !! {}", e.getMessage());
        }

        mv.addObject("list", boardList);
        return mv;
    }
}
