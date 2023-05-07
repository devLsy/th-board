package study.example.thboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import study.example.thboard.vo.Reply;

import java.util.List;

@Repository @Mapper
public interface ReplyMapper {

    /* 댓글 목록 조회 */
    List<Reply> selectReplys(@Param("boardNo") int boardNo);

    /* 댓글 상세 조회 */
    Reply selectReplyDetail(@Param("boardNo") int boardNo, @Param("replyNo") int replyNo);

    /* 댓글 저장 */
    void insertReply(Reply reply);

    /* 댓글 수정 */
    void updateReply(Reply reply);

    /* 댓글 삭제 */
    void delReply(Reply reply);
        
    /* 댓글 카운트 */
    int selectReplyCnt(@Param("boardNo") int boardNo);
}
