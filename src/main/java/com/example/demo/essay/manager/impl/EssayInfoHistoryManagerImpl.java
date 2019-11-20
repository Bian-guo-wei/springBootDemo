package com.example.demo.essay.manager.impl;

import com.dayainfo.lib.search.model.PageBean;
import com.dayainfo.lib.search.util.PageHelperUtil;
import com.example.demo.essay.manager.EssayInfoHistoryManager;
import com.example.demo.essay.mapper.EssayInfoHistoryPoMapper;
import com.example.demo.essay.model.po.EssayInfoHistoryPo;
import com.example.demo.essay.model.po.EssayInfoHistoryPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/10/10.
 */
@Service
public class EssayInfoHistoryManagerImpl implements EssayInfoHistoryManager {

    @Autowired
    private EssayInfoHistoryPoMapper essayInfoHistoryPoMapper;


    @Override
    public PageBean<EssayInfoHistoryPo> getHistoryEssayFront(int currentPage, int pageSize) {
        EssayInfoHistoryPoExample essayInfoHistoryPoExample = new EssayInfoHistoryPoExample();
        essayInfoHistoryPoExample.setOrderByClause("gmt_create desc");
        PageBean<EssayInfoHistoryPo> pageBean = new PageBean<>();

        pageBean.setCurrentPage(currentPage);
        pageBean.setPagesize(pageSize);
        PageHelperUtil.startPage(pageBean);
        List<EssayInfoHistoryPo> list = essayInfoHistoryPoMapper.selectByExample(essayInfoHistoryPoExample);
        pageBean.setTotalData(essayInfoHistoryPoMapper.countByExample(essayInfoHistoryPoExample));
        pageBean.setList(list);
        pageBean.initbeginPageAndEndPage();
        return pageBean;
    }

    @Override
    public void getHistoryEssayBack(PageBean<EssayInfoHistoryPo> EssayInfoHistoryPageBean) {
        EssayInfoHistoryPoExample essayInfoHistoryPoExample = new EssayInfoHistoryPoExample();
        essayInfoHistoryPoExample.setOrderByClause("gmt_create desc");

        EssayInfoHistoryPageBean.setTotalData(getHistoryEssayCount());
        PageHelperUtil.startPage(EssayInfoHistoryPageBean);
        List<EssayInfoHistoryPo> list = essayInfoHistoryPoMapper.selectByExample(essayInfoHistoryPoExample);
        EssayInfoHistoryPageBean.setList(list);

    }

    @Override
    public EssayInfoHistoryPo getEssayInfoHistoryByUuid(String Uuid) {
        EssayInfoHistoryPoExample essayInfoHistoryPoExample = new EssayInfoHistoryPoExample();
        essayInfoHistoryPoExample.createCriteria().andUuidEqualTo(Uuid);
        List<EssayInfoHistoryPo> essayInfoHistoryPoList = essayInfoHistoryPoMapper.selectByExample(essayInfoHistoryPoExample);
        return essayInfoHistoryPoList.get(0);
    }

    @Override
    public int deleteEssayInfoHistory(String Uuid) {
        EssayInfoHistoryPoExample essayInfoHistoryPoExample = new EssayInfoHistoryPoExample();
        essayInfoHistoryPoExample.createCriteria().andUuidEqualTo(Uuid);
        int count = essayInfoHistoryPoMapper.deleteByExample(essayInfoHistoryPoExample);
        return count;
    }

    @Override
    public int updateEssayInfoHistoryDetail(EssayInfoHistoryPo essayInfoHistoryPo) {
        EssayInfoHistoryPoExample essayInfoHistoryPoExample = new EssayInfoHistoryPoExample();
        essayInfoHistoryPoExample.createCriteria().andUuidEqualTo(essayInfoHistoryPo.getUuid());
        int count = essayInfoHistoryPoMapper.updateByExampleSelective(essayInfoHistoryPo,essayInfoHistoryPoExample);
        return count;
    }

    private int getHistoryEssayCount() {
        EssayInfoHistoryPoExample essayInfoHistoryPoExample = new EssayInfoHistoryPoExample();
        int count = essayInfoHistoryPoMapper.countByExample(essayInfoHistoryPoExample);
        return count;
    }


}
