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

    /**
     * 댓글 상세 조회
     * @param replyNo
     * @return
     */
    public Reply getReply(int replyNo) throws Exception{
        return replyMapper.selectReplyDetail(replyNo);
    }

    /**
     * 댓글 등록 
     * @param reply
     * @return
     */
    @Transactional
    public void saveReply(Reply reply) throws Exception{
        replyMapper.insertReply(reply);
    }

    /**
     * 댓글 수정
     * @param reply
     */
    @Transactional
    public void modifyReply(Reply reply) throws Exception{
        replyMapper.updateReply(reply);
    }

    /**
     * 댓글 삭제 
     * @param replyNo
     */
    @Transactional
    public void removeReply(int replyNo) throws Exception{
        replyMapper.delReply(replyNo);
    }

    /**
     * 댓글 카운트
     * @param boardNo
     * @return
     */
    public int getReplyCnt(int boardNo) throws Exception{
        return replyMapper.selectReplyCnt(boardNo);
    }
}
