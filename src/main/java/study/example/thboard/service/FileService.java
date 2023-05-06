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
import java.util.List;
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
    @Transactional
    public void saveFile(MultipartFile files, int boardNo) throws IOException, Exception{
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
        //파일정보 DB 저장
        FileVo fileVo = new FileVo();
        fileVo.setOrgFileName(orgFileName);
        fileVo.setFileSize((int) files.getSize());
        fileVo.setBoardNo(boardNo);
        fileVo.setFilePath(path);
        fileMapper.insertFile(fileVo);
    }

    /**
     * 파일 정보 상세
     * @param fileNo
     * @return
     */
    public FileVo getFileDetail(int fileNo) throws Exception{
        return fileMapper.selectFileDetail(fileNo);
    }

    /**
     * 파일 목록 조회
     * @param boardNo
     * @return
     */
    public List<FileVo> getFileList(int boardNo) throws Exception{
        return fileMapper.selectFileList(boardNo);
    }

}
