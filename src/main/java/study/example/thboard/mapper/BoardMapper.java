package study.example.thboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import study.example.thboard.vo.BoardVo;

import java.util.List;

@Repository @Mapper
public interface BoardMapper {
    /* 게시글 목록 조회 */
    List<BoardVo> selectBoards(BoardVo boardVo);

    /* 게시글 등록 */
    int insertBoard(BoardVo boardVo);

    /* 게시글 상세 */
    BoardVo selectBoardDetail(@Param("boardNo") int boardNo);

    /* 게시글 수정 */
    void updateBoard(BoardVo boardVo);

    /* 게시글 삭제 */
    void deleteBoard(@Param("boardNo") int boardNo);
}
