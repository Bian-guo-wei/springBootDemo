package com.example.demo.essay.manager.impl;

import com.example.demo.essay.manager.ClickCountManager;
import com.example.demo.essay.mapper.ClickCountPoMapper;
import com.example.demo.essay.model.po.ClickCountPo;
import com.example.demo.essay.model.po.ClickCountPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClickCountManagerImpl implements ClickCountManager {
    @Autowired
    private ClickCountPoMapper clickCountPoMapper;
    @Override
    public Integer getEssayClickCount(String essayId) {
        ClickCountPoExample clickCountPoExample = new ClickCountPoExample();
        clickCountPoExample.createCriteria().andEssayIdEqualTo(essayId);
        List<ClickCountPo> clickCountPos = clickCountPoMapper.selectByExample(clickCountPoExample);
        return clickCountPos.get(0).getClickCount();
    }
    @Override
    public void updateEssayClickCount(Integer count, String essayId) {
        ClickCountPoExample clickCountPoExample = new ClickCountPoExample();
        clickCountPoExample.createCriteria().andEssayIdEqualTo(essayId);
        ClickCountPo clickCountPo = new ClickCountPo();
        clickCountPo.setClickCount(count);
        clickCountPoMapper.updateByExampleSelective(clickCountPo,clickCountPoExample);
    }
    @Override
    public void handleEssayClick(String essayId) {
        Boolean hasEssay = selectEssayByEssayId(essayId);
        if(!hasEssay) {
            insertNewClickCount(essayId);
        }
    }
    @Override
    public void insertNewClickCount(String essayId) {
        ClickCountPoExample clickCountPoExample = new ClickCountPoExample();
        clickCountPoExample.createCriteria();
        ClickCountPo clickCountPo = new ClickCountPo();
        clickCountPo.setEssayId(essayId);
        clickCountPo.setClickCount(0);
        clickCountPoMapper.insertSelective(clickCountPo);
    }
    @Override
    public Boolean selectEssayByEssayId(String essayId) {
        ClickCountPoExample clickCountPoExample = new ClickCountPoExample();
        clickCountPoExample.createCriteria().andEssayIdEqualTo(essayId);
        List<ClickCountPo> clickCountPos = clickCountPoMapper.selectByExample(clickCountPoExample);
        if(clickCountPos.size() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
