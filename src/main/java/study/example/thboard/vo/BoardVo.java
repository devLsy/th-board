package study.example.thboard.vo;

import lombok.Data;

@Data
public class BoardVo extends CommonVo{

    private int no;
    private int boardNo;
    private String keyword;
    private String type;
    private String title;
    private String content;
    private String writer;
    private String useYn;
}
