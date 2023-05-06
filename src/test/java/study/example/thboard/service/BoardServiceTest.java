package study.example.thboard.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import study.example.thboard.mapper.BoardMapper;
import study.example.thboard.vo.BoardVo;

@SpringBootTest
@Slf4j
class BoardServiceTest {

    @Autowired
    BoardMapper boardMapper;

//    @Test
//    @DisplayName("등록")
//    @Commit
//    public void 등록() throws Exception {
//        //givin
//        BoardVo boardVo = new BoardVo();
//        boardVo.setTitle("제목2");
//        boardVo.setContent("내용2");
//        boardVo.setWriter("lsy");
//
//        boardMapper.insertBoard(boardVo);
//        //when
//        //then
//    }

//    @Test
//    @DisplayName("상세")
//    @Commit
//    public void 상세() throws Exception {
//        //givin
//        BoardVo info = boardMapper.selectBoardDetail(1L);
//        //when
//
//        //then
//    }

//    @Test
//    @DisplayName("수정")
//    @Commit
//    public void 수정() throws Exception {
//        //givin
//        BoardVo boardVo = new BoardVo();
//        boardVo.setBoardNo(3);
//        boardVo.setTitle("진풍백");
//        boardVo.setContent("천마군황보!!!");
//        boardMapper.updateBoard(boardVo);
//        //when
//
//        //then
//    }

//    @Test
//    @DisplayName("삭제")
//    @Commit
//    public void 삭제() throws Exception {
//        //givin
//        boardMapper.deleteBoard(1);
//        //when
//
//        //then
//    }

}