package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import study.example.thboard.service.BoardService;
import study.example.thboard.service.FileService;
import study.example.thboard.service.UserService;
import study.example.thboard.vo.BoardVo;
import study.example.thboard.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/")
public class MainController {

    private final BoardService boardService;
    private final FileService fileService;

    /**
     * 게시글 목록 조회
     * @return
     */
    @GetMapping(value = "")
    public ModelAndView main(@ModelAttribute BoardVo boardVo) {
        ModelAndView mv = new ModelAndView("pages/index");
        List<BoardVo> boardList = null;

        try {
            boardList = boardService.getBoards(boardVo);
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
        ModelAndView mv = new ModelAndView("pages/regForm");
        mv.addObject("board", new BoardVo());
        return mv;
    }

    /**
     * 게시글 등록 처리
     * @param boardVo
     * @return
     */
    @PostMapping("reg")
    public String reg(@ModelAttribute BoardVo boardVo,
                      @RequestParam("files") List<MultipartFile> files,
                      HttpServletRequest request) {

        try {
            //TODO 게시글 작성 후 생성된 시퀀스값을 파일 저장 시 param값으로 던져야 함
            boardService.regBoard(boardVo);
            //파일 저장
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    fileService.saveFile(file, boardVo.getBoardNo());
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
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
        return "redirect:/";
    }

    /**
     * 게시글 삭제
     * @param boardNo
     * @return
     */
    @PostMapping("del")
    public String del(@RequestParam int boardNo) {
        try {
            boardService.deleteBoard(boardNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }


}
