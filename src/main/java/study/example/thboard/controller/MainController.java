package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.tools.shell.IO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;
import study.example.thboard.service.BoardService;
import study.example.thboard.service.FileService;
import study.example.thboard.service.UserService;
import study.example.thboard.vo.BoardVo;
import study.example.thboard.vo.FileVo;
import study.example.thboard.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
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

    //파일 이미지 출력
//    @GetMapping("images/{fileNo}")
    @ResponseBody
    public Resource downloadImage(@PathVariable("fileNo") int fileNo, Model model) throws IOException {
        FileVo fileInfo = null;
        try {
            fileInfo = fileService.getFileDetail(fileNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String filePath = fileInfo.getFilePath();
        return new UrlResource("file: " + filePath);
    }

    //파일 다운로드
//    @GetMapping("/download/{fileNo}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int fileNo) throws IOException{
        FileVo fileInfo = null;
        try {
            fileInfo = fileService.getFileDetail(fileNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UrlResource resource = new UrlResource("file: " + fileInfo.getFilePath());

        String encodeFileName = UriUtils.encode(fileInfo.getOrgFileName(), StandardCharsets.UTF_8);

        //파일 다운로드 대화상자 표시
        String contentDisposition = "attachment; filename=\"" + encodeFileName + "\"";

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
    }

}
