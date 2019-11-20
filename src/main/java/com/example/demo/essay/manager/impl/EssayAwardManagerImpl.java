package com.example.demo.essay.manager.impl;

import com.dayainfo.common.util.StringUtils;
import com.dayainfo.lib.search.model.PageBean;
import com.dayainfo.lib.search.util.PageHelperUtil;
import com.example.demo.essay.manager.EssayAwardManager;
import com.example.demo.essay.mapper.EssayAwardPoMapper;
import com.example.demo.essay.model.po.EssayAwardPo;
import com.example.demo.essay.model.po.EssayAwardPoExample;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EssayAwardManagerImpl implements EssayAwardManager {
    private static final Logger logger = LoggerFactory.getLogger(EssayAwardManagerImpl.class);
    @Autowired
    EssayAwardPoMapper essayAwardPoMapper;
    @Override
    public Boolean order(EssayAwardPo po) {
        if (po.getAdminId() < 0
                || StringUtils.isBlank(po.getEssayId())
                || StringUtils.isBlank(po.getArticleTitle())
                || StringUtils.isBlank(po.getCompetitorName())
                || StringUtils.isBlank(po.getEssayName())
                || StringUtils.isBlank(po.getAwardName())
                ) {
            return Boolean.FALSE;
        }
        po.setStatus(1);
        po.setIsDisplay(1);
        po.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        try {
            essayAwardPoMapper.insertSelective(po);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("order -> e : " + e);
            return Boolean.FALSE;
        }
    }

    @Override
    public PageBean<EssayAwardPo> listEssayAwards(int currentPage, int pageSize, String essayNameSearchValue) {
        PageBean<EssayAwardPo> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPagesize(pageSize);
        EssayAwardPoExample example = new EssayAwardPoExample();
        example.createCriteria().andEssayNameLike("%"+essayNameSearchValue+"%");
        pageBean.setTotalData(essayAwardPoMapper.countByExample(example));
        PageHelperUtil.startPage(pageBean);
        List<EssayAwardPo> list = essayAwardPoMapper.selectByExample(example);
        pageBean.setList(list);
        pageBean.initbeginPageAndEndPage();
        return pageBean;
    }

    @Override
    public PageBean<EssayAwardPo> listEssayAwards4Mobile(int currentPage, int pageSize, String essayId) {
        PageBean<EssayAwardPo> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPagesize(pageSize);
        EssayAwardPoExample example = new EssayAwardPoExample();
        example.createCriteria().andEssayIdEqualTo(essayId);
        pageBean.setTotalData(essayAwardPoMapper.countByExample(example));
        Page page = new PageHelperUtil().startPageAndCount(pageBean);
        List<EssayAwardPo> list = essayAwardPoMapper.selectByExample(example);
        pageBean.setList(list);
        pageBean.setTotalData((int)page.getTotal());
        pageBean.initbeginPageAndEndPage();
        return pageBean;
    }

    @Override
    public List<EssayAwardPo> lisAlltEssayAwards(String essayNameSearchValue) {
        EssayAwardPoExample example = new EssayAwardPoExample();
        example.createCriteria().andEssayNameLike("%"+essayNameSearchValue+"%");
        return essayAwardPoMapper.selectByExample(example);
    }
}
