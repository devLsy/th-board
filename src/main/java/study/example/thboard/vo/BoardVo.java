package study.example.thboard.vo;

import lombok.Data;

@Data
//게시글 관련
public class BoardVo extends CommonVo{

    private int no;
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private String useYn;
}
