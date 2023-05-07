package study.example.thboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.example.thboard.service.ReplyService;
import study.example.thboard.vo.Reply;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReplyController {

    private final ReplyService replyService;

    /**
     * 댓글 목록 조회
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
}
