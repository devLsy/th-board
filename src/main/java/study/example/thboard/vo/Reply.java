package study.example.thboard.vo;

import lombok.Data;

@Data
//댓글 vo
public class Reply extends CommonVo{

    private int replyNo;
    private int boardNo;
    private String replyContent;
    private String replyWriter;
    private String delYn;
}
