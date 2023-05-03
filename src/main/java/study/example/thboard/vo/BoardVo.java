package study.example.thboard.vo;

import lombok.Data;

@Data
public class BoardVo extends CommonVo{

    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private String useYn;
}