package study.example.thboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import study.example.thboard.vo.FileVo;

import java.util.List;

@Repository @Mapper
public interface FileMapper {

    /* 파일 정보 저장 */
    void insertFile(FileVo fileVo);

    /* 파일 정보 상세 */
//    FileVo selectFileDetail(@Param("fileNo") int fileNo, @Param("boardNo") int boardNo);
    FileVo selectFileDetail(@Param("fileNo") int fileNo);

    /* 파일 목록 조회 */
    List<FileVo> selectFileList(@Param("boardNo") int boardNo);

    /* 파일 정보 수정 */
    void updateFile(FileVo fileVo);

    /* 파일 정보 삭제 */  
    void deleteFile(@Param("fileNo") int fileNo, @Param("boardNo") int boardNo);


}
