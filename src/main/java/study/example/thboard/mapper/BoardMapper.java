package study.example.thboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import study.example.thboard.vo.BoardVo;

import java.util.List;

@Repository @Mapper
public interface BoardMapper {

    List<BoardVo> selectBoards();
}
