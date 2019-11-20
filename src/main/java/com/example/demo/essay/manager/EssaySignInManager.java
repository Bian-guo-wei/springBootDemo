package com.example.demo.essay.manager;

import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.essay.model.po.EssaySignInPo;

public interface EssaySignInManager {
    Boolean order(EssaySignInPo po);
    Boolean isTimeCorrect(EssaySignInPo po);
    Boolean isSignIn(EssaySignInPo po);
    PageBean<EssaySignInPo> listSignIn(String name, String essayName, String unit, int currentPage, int pageSize);
}
