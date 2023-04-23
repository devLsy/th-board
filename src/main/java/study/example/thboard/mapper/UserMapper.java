package study.example.thboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import study.example.thboard.vo.BoardVo;
import study.example.thboard.vo.UserVo;

import java.util.List;

@Repository @Mapper
public interface UserMapper {

    List<UserVo> selectUsers();
}
