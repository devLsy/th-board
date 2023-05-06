package study.example.thboard.vo;

import lombok.Data;

@Data
//첨부파일 관련 vo
public class FileVo extends CommonVo{
    private int fileNo;
    private int boardNo;
    private String orgFileName;
    private String filePath;
    private int fileSize;
    private String delYn;
}
