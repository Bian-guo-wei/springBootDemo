package com.example.demo.essay.manager;

import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.essay.model.po.EssayInfoHistoryPo;

/**
 * Created by admin on 2019/10/10.
 */
public interface EssayInfoHistoryManager {

    PageBean<EssayInfoHistoryPo> getHistoryEssayFront(int currentPage, int pageSize);

    void getHistoryEssayBack(PageBean<EssayInfoHistoryPo> EssayInfoHistoryPageBean);

    EssayInfoHistoryPo getEssayInfoHistoryByUuid(String Uuid);

    int deleteEssayInfoHistory(String Uuid);

    int updateEssayInfoHistoryDetail(EssayInfoHistoryPo essayInfoHistoryPo);
}
