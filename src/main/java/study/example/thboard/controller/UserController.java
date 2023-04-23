package study.example.thboard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping(value = "")
    public Object list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user");
        return mv;
    }
}
