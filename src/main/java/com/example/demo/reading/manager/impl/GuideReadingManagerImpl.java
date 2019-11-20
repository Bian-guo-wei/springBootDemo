package com.example.demo.reading.manager.impl;

import com.example.demo.reading.manager.GuideReadingManager;
import com.example.demo.reading.mapper.GuideReadingPoMapper;
import com.example.demo.reading.model.po.GuideReadingPo;
import com.example.demo.reading.model.po.GuideReadingPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/9/25.
 */
@Service
public class GuideReadingManagerImpl implements GuideReadingManager {

    @Autowired
    private GuideReadingPoMapper guideReadingPoMapper;

    @Override
    public Boolean insert(GuideReadingPo guideReadingPo) {
        int count = guideReadingPoMapper.insert(guideReadingPo);
        if (count < 1){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean update(GuideReadingPo guideReadingPo) {
        GuideReadingPoExample example = new GuideReadingPoExample();
        int count = guideReadingPoMapper.countByExample(example);
        if (count < 1){
            int count1 = guideReadingPoMapper.insert(guideReadingPo);
            if (count1 < 1){
                return false;
            }else {
                return true;
            }
        }else {
            int count2 = guideReadingPoMapper.updateByPrimaryKeySelective(guideReadingPo);
            if (count2 < 1){
                return false;
            }else {
                return true;
            }
        }
    }

    @Override
    public List<GuideReadingPo> getInfo() {
        List<GuideReadingPo> list = guideReadingPoMapper.selectByExample();
        return list;
    }
}
