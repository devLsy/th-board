package study.example.thboard.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.example.thboard.mapper.BoardMapper;
import study.example.thboard.mapper.UserMapper;
import study.example.thboard.vo.BoardVo;
import study.example.thboard.vo.UserVo;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserMapper userMapper;

    /**
     * 아이디/패스워드 확인
     * @param id
     * @param password
     * @return
     */
    public String  login(String id, String password) {
        UserVo useInfo = userMapper.selectById(id);

        return useInfo.getPassword().equals(password) ? useInfo.getId() : null;
    }
}
