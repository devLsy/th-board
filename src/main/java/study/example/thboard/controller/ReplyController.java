package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.example.thboard.service.ReplyService;
import study.example.thboard.vo.Reply;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReplyController {

    private final ReplyService replyService;

    /**
     * 댓글 목록 조회
     *
     * @param boardNo
     * @return
     */
    @GetMapping(value = "/replys/{boardNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reply>> list(@PathVariable("boardNo") int boardNo) {

        List<Reply> replyList = null;
        try {
            replyList = replyService.getReplys(boardNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(replyList, HttpStatus.OK);
    }

    /**
     * 댓글 등록
     *
     * @param boardNo
     * @return
     */
    @PostMapping(value = "/replys/{boardNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int saveReply(@PathVariable int boardNo, @ModelAttribute Reply reply) throws Exception {
        replyService.saveReply(reply);
        return reply.getReplyNo();
    }

    /**
     * 댓글 삭제
     *
     * @param replyNo
     * @return
     * @throws Exception
     */
    @DeleteMapping(value = "/replys/{replyNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delReply(@PathVariable int replyNo) throws Exception {
        replyService.removeReply(replyNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 댓글 수정
     * @param reply
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/replys/update/{replyNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateReply(@ModelAttribute Reply reply) throws Exception{
        replyService.modifyReply(reply);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
