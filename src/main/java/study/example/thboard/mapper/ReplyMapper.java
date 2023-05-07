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
}
