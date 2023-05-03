package study.example.thboard.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.example.thboard.mapper.BoardMapper;
import study.example.thboard.vo.BoardVo;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardMapper boardMapper;

    /**
     * 게시글 목록 조회 
     * @return
     */
    public List<BoardVo> getBoards() throws Exception{
        return boardMapper.selectBoards();
    }

    /**
     * 게시글 등록
     * @param boardVo
     */
    public void regBoard(BoardVo boardVo) throws Exception{
        boardMapper.insertBoard(boardVo);
    }

    /**
     * 게시글 상세 조회
     * @param boardNo
     * @return
     */
    public BoardVo getBoard(int boardNo) throws Exception{
        return boardMapper.selectBoardDetail(boardNo);
    }

    /**
     * 게시글 수정
     * @param boardVo
     */
    public void modifyBoard(BoardVo boardVo) throws Exception{
        boardMapper.updateBoard(boardVo);
    }
}
