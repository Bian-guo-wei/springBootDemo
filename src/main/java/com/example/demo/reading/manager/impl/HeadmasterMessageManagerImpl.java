package com.example.demo.reading.manager.impl;

import com.example.demo.reading.manager.HeadmasterMessageManager;
import com.example.demo.reading.mapper.HeadmasterMessagePoMapper;
import com.example.demo.reading.model.po.HeadmasterMessagePo;
import com.example.demo.reading.model.po.HeadmasterMessagePoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/9/25.
 */
@Service
public class HeadmasterMessageManagerImpl implements HeadmasterMessageManager {

    @Autowired
    private HeadmasterMessagePoMapper headmasterMessagePoMapper;

    @Override
    public Boolean insert(HeadmasterMessagePo headmasterMessagePo) {
        int count = headmasterMessagePoMapper.insert(headmasterMessagePo);
        if (count < 1){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean update(HeadmasterMessagePo headmasterMessagePo) {
        HeadmasterMessagePoExample example = new HeadmasterMessagePoExample();
        int count = headmasterMessagePoMapper.countByExample(example);
        if (count < 1){
            int count1 = headmasterMessagePoMapper.insert(headmasterMessagePo);
            if (count1 < 1){
                return false;
            }else {
                return true;
            }
        }else {
            int count2 = headmasterMessagePoMapper.updateByPrimaryKeySelective(headmasterMessagePo);
            if (count2 < 1){
                return false;
            }else {
                return true;
            }
        }
    }

    @Override
    public List<HeadmasterMessagePo> getInfo() {
        List<HeadmasterMessagePo> list = headmasterMessagePoMapper.selectByExample();
        return list;
    }
}
