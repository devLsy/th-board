package study.example.thboard.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import study.example.thboard.mapper.FileMapper;
import study.example.thboard.vo.FileVo;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class FileServiceTest {

    @Autowired
    FileMapper fileMapper;

//    @Test
//    @DisplayName("파일등록")
//    @Commit
//    public void 파일등록() throws Exception {
//        //givin
//        FileVo fileVo = new FileVo();
//        fileVo.setBoardNo(4);
//        fileVo.setOrgFileName("천마신군.jpg");
//        fileVo.setFilePath("D:\\upload\\");
//        fileVo.setFileSize(1111);
//        fileMapper.updateFile(fileVo);
//        //when
//
//        //then
//    }

//    @Test
//    @DisplayName("파일수정")
//    @Commit
//    public void 파일수정() throws Exception {
//        //givin
//        FileVo fileVo = new FileVo();
//        fileVo.setFileNo(2);
//        fileVo.setBoardNo(4);
//        fileVo.setOrgFileName("검마.jpg");
//        fileVo.setFilePath("D:\\upload\\");
//        fileVo.setFileSize(3333);
//        fileMapper.updateFile(fileVo);
//        //when
//
//        //then
//    }
//    @Test
//    @DisplayName("파일삭제")
//    @Commit
//    public void 파일삭제() throws Exception {
//        //givin
//        fileMapper.deleteFile(2, 4);
//        //when
//
//        //then
//    }
//    @Test
//    @DisplayName("파일상세")
//    @Commit
//    public void 파일상세() throws Exception {
//        //givin
//        fileMapper.selectFileDetail(2, 4);
//
//        //when
//
//        //then
//    }
    
}