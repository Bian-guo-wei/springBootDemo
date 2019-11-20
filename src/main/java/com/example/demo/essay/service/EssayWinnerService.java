package com.example.demo.essay.service;
import com.example.demo.essay.model.bo.ExcelImportResultBo;
import com.example.demo.essay.model.po.EssayAwardPo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EssayWinnerService {
    /**
     * excel
     * 下载
     *
     * @param response  respose
     * @param sheetName xls表明
     * @param result    list
     */
    void resultSetToExcel(HttpServletResponse response, String sheetName, List<EssayAwardPo> result);

    /**
     * excel导入获奖名单
     *
     * @param file
     * @param essayId
     * @return bo
     */
    ExcelImportResultBo insertWinnerFromExcel(MultipartFile file, String essayId, int adminId, int type);
}
