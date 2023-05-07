package study.example.thboard.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.example.thboard.mapper.ReplyMapper;
import study.example.thboard.vo.Reply;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {

    private final ReplyMapper replyMapper;

    /**
     * 댓글 목록 조회
     * @param boardNo
     * @return
     */
    public List<Reply> getReplys(int boardNo) throws Exception{
        return replyMapper.selectReplys(boardNo);
    }
}
