package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    @GetMapping(value = "/")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/main");
        return mv;
    }


}
