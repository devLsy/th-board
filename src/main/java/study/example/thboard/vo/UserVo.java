package study.example.thboard.vo;

import lombok.Data;

@Data
public class UserVo extends CommonVo{

    private Long userNo;
    private String id;
    private String password;
    private String name;
    private String email;
}
