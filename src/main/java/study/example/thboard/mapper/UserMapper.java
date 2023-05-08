package study.example.thboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import study.example.thboard.vo.BoardVo;
import study.example.thboard.vo.UserVo;

import java.util.List;

@Repository @Mapper
public interface UserMapper {
    
    /* 아이디로 사용자 정보 조회 */
    UserVo selectByIdAndNo(@Param("id") String id);
}
