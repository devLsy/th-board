package study.example.thboard.vo;

import lombok.Data;

@Data
public class Criteria {

    //검색 타입
    private String type;
    //검색 키워드
    private String keyword;

    private int pageNum;     // 페이지 번호(현재 페이지가 몇 페이지인지)
    private int amount;      // 한 화면에 출력한 페이지 개수

    public Criteria() {
        this(1,10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}
