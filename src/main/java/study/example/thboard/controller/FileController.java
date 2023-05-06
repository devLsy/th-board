package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;
import study.example.thboard.service.FileService;
import study.example.thboard.vo.FileVo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final FileService fileService;

    @GetMapping("/upload")
    public String testUploadForm() {
        return "pages/uploadTest";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file, List<MultipartFile> files) throws Exception {
        //단일 파일 저장
        fileService.saveFile(file, 1);
        //다중 파일 저장
        for (MultipartFile multipartFile : files) {
            fileService.saveFile(multipartFile, 1);
        }
        return "redirect:/";
    }

    @GetMapping("/view")
    public String view(Model model) {
        try {
            List<FileVo> fileList = fileService.getFileList(1);
            model.addAttribute("all", fileList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pages/view";
    }

    @GetMapping("/images/{fileNo}")
    @ResponseBody
    public Resource downloadImage(@PathVariable int fileNo, Model model) throws Exception{
        FileVo fileDetail = fileService.getFileDetail(fileNo);
        //아래에서 에러 발생(path....)
        return new UrlResource("file:" + fileDetail.getFilePath());
    }
    
    //파일 다운로드
    @GetMapping("/download/{fileNo}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int fileNo) throws Exception {

        FileVo fileInfo = fileService.getFileDetail(fileNo);

        UrlResource resource = new UrlResource("file:" + fileInfo.getFilePath());

        String encodeFileName = UriUtils.encode(fileInfo.getOrgFileName(), StandardCharsets.UTF_8);

        //파일 다운로드 대화상자 표시
        String contentDisposition = "attachment; filename=\"" + encodeFileName + "\"";

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
    }
}
