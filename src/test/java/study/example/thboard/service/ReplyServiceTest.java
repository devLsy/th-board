package study.example.thboard.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import study.example.thboard.vo.Reply;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ReplyServiceTest {

    @Autowired
    ReplyService replyService;

//    @Test
//    @DisplayName("댓글등록")
//    @Commit
//    public void 댓글등록() throws Exception {
//        //givin
//        Reply reply = new Reply();
//        reply.setBoardNo(353823);
//        reply.setContent("댓글이다.");
//        reply.setWriter("흑풍");
//        replyService.saveReply(reply);
//        //when
//
//        //then
//    }

//    @Test
//    @DisplayName("댓글수정")
//    @Commit
//    public void 댓글수정() throws Exception {
//        //givin
//        Reply repyInfo = replyService.getReply(353823, 2);
//        repyInfo.setContent("댓글 수정이다.");
//        replyService.modifyReply(repyInfo);
//
//        //when
//
//        //then
//    }
    
//    @Test
//    @DisplayName("나머지테스트")
//    @Commit
//    public void 나머지테스트() throws Exception {
        //givin
//        Reply repyInfo = replyService.getReply(353823, 2);
//        replyService.removeReply(repyInfo);
        //when
//        replyService.getReplyCnt(353823);
        //then 
//    }

}