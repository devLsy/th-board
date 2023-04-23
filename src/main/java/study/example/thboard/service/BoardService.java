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

    public List<BoardVo> getBoards() {
        return boardMapper.selectBoards();
    }
}
