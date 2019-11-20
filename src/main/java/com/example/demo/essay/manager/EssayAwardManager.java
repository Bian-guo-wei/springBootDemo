package com.example.demo.essay.manager;


import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.essay.model.po.EssayAwardPo;

import java.util.List;

public interface EssayAwardManager {
    Boolean order(EssayAwardPo po);
    PageBean<EssayAwardPo> listEssayAwards(int currentPage, int pageSize, String essayNameSearchValue);
    PageBean<EssayAwardPo> listEssayAwards4Mobile(int currentPage, int pageSize, String essayId);
    List<EssayAwardPo> lisAlltEssayAwards(String essayNameSearchValue);
}
