package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.example.thboard.service.BoardService;
import study.example.thboard.service.UserService;
import study.example.thboard.vo.BoardVo;
import study.example.thboard.vo.UserVo;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/main")
public class MainController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping(value = "")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();

        List<BoardVo> boardList = boardService.getBoards();
        List<UserVo> userList = userService.getUsers();

        mv.addObject("list", boardList);
        mv.addObject("userList", userList);
        mv.setViewName("pages/main");
        return mv;
    }


}
