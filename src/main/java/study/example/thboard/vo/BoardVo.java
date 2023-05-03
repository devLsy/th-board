package study.example.thboard.vo;

import lombok.Data;

@Data
public class BoardVo extends CommonVo{

    private Long boardNo;
    private String title;
    private String content;
    private String writer;
}
