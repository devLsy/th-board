package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import study.example.thboard.service.BoardService;
import study.example.thboard.service.FileService;
import study.example.thboard.vo.BoardVo;
import study.example.thboard.vo.Criteria;
import study.example.thboard.vo.PageMaker;
import study.example.thboard.vo.FileVo;

import javax.servlet.http.HttpServletRequest;
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
     * @param cri
     * @return
     */
    @GetMapping(value = "")
    public ModelAndView main(@ModelAttribute Criteria cri) {

        ModelAndView mv = new ModelAndView("pages/index");
        List<BoardVo> boardList = null;

        try {
            int totBoardCnt = boardService.getTotBoardCnt();
            //게시글 목록
            boardList = boardService.getBoards(cri);
            PageMaker pageMaker = new PageMaker(totBoardCnt, cri);
            mv.addObject("list", boardList);
            mv.addObject("cri", cri);
            mv.addObject("pageMaker", pageMaker);

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
            List<FileVo> fileList = fileService.getFileList(boardNo);
            mv.addObject("info", info);
            mv.addObject("files", fileList);
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
