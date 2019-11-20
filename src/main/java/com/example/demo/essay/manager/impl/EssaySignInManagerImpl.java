package com.example.demo.essay.manager.impl;

import com.dayainfo.lib.search.model.PageBean;
import com.dayainfo.lib.search.util.PageHelperUtil;
import com.example.demo.essay.manager.EssayInfoManager;
import com.example.demo.essay.manager.EssaySignInManager;
import com.example.demo.essay.mapper.EssaySignInPoMapper;
import com.example.demo.essay.model.po.EssaySignInPo;
import com.example.demo.essay.model.po.EssaySignInPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EssaySignInManagerImpl implements EssaySignInManager {
    @Autowired
    EssaySignInPoMapper mapper;
    @Autowired
    EssayInfoManager essayInfoManager;
    @Override
    public Boolean order(EssaySignInPo po) {
        po.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        return mapper.insertSelective(po) == 1;
    }

    @Override
    public Boolean isTimeCorrect(EssaySignInPo po) {
        Timestamp end = essayInfoManager.selectOneEssayinfoByUuid(po.getEssayId()).getDuration();
        Timestamp start = essayInfoManager.selectOneEssayinfoByUuid(po.getEssayId()).getStart();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return time.after(start) && time.before(end);
    }

    @Override
    public Boolean isSignIn(EssaySignInPo po) {
        EssaySignInPoExample example = new EssaySignInPoExample();
        example.createCriteria().andEssayIdEqualTo(po.getEssayId()).andPuidEqualTo(po.getPuid());
        return mapper.countByExample(example) > 0;
    }

    @Override
    public PageBean<EssaySignInPo> listSignIn(String name, String essayName, String unit, int currentPage, int pageSize) {
        PageBean<EssaySignInPo> pageBean = new PageBean<>();
        pageBean.setPagesize(pageSize);
        pageBean.setCurrentPage(currentPage);
        EssaySignInPoExample example = new EssaySignInPoExample();
        example.createCriteria().andNameLike("%"+name+"%").andEssayNameLike("%"+essayName+"%").andUnitLike("%"+unit+"%");
        pageBean.setTotalData(mapper.countByExample(example));
        PageHelperUtil.startPage(pageBean);
        List<EssaySignInPo> list = mapper.selectByExample(example);
        pageBean.setList(list);
        pageBean.initbeginPageAndEndPage();
        return pageBean;
    }
}
