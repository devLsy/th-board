package study.example.thboard.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import study.example.thboard.mapper.FileMapper;
import study.example.thboard.vo.FileVo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FileService {

    private final FileMapper fileMapper;

    @Value("${file.path}")
    private String filePath;

    /**
     * 파일 업로드
     * @param files
     * @param boardNo
     * @return
     */
    public void saveFile(MultipartFile files, int boardNo) throws IOException{
        //원본 파일 이름
        String orgFileName = files.getOriginalFilename();
        //파일 uuid
        String uuid = UUID.randomUUID().toString();
        //파일 확장자
        String extension = orgFileName.substring(orgFileName.lastIndexOf("."));
        //서버에 저장될 파일명
        String saveFileName = uuid + extension;
        //파일 저장 경로
        String path = filePath + saveFileName;
        //파일 저장
        files.transferTo(new File(path));

        FileVo fileVo = new FileVo();
        fileVo.setOrgFileName(orgFileName);
        fileVo.setFileSize((int) files.getSize());
        fileVo.setBoardNo(boardNo);
        fileVo.setFilePath(filePath);
        fileMapper.insertFile(fileVo);
    }
}
