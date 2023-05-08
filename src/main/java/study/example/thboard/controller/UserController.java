package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.example.thboard.service.UserService;
import study.example.thboard.vo.UserVo;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * 로그인 화면
     * @param session
     * @return
     */
    @GetMapping("/login")
    public String loginForm(HttpSession session) {
        Long id = (Long)session.getAttribute("id");
        return id != null ? "redirect:/" : "pages/login" ;
    }

    /**
     * 로그인 처리 
     * @param userVo
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(UserVo userVo, HttpSession session) {
        Long id = userService.login(userVo.getId(), userVo.getPassword());
        if(id == null) return "redirect:/login";

        session.setAttribute("id", id);
        return "redirect:/";
    }
}
