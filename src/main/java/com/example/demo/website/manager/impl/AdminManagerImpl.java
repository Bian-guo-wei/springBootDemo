package com.example.demo.website.manager.impl;

import com.example.demo.website.manager.AdminManager;
import com.example.demo.reading.mapper.AdministratorPoMapper;
import com.example.demo.reading.model.po.AdministratorPo;
import com.example.demo.reading.model.po.AdministratorPoExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ayne
 * @date 2019-04-02 15:57:37
 */
@Service
public class AdminManagerImpl implements AdminManager {

    private static final Logger logger = LoggerFactory.getLogger(AdminManagerImpl.class);

    @Autowired
    private AdministratorPoMapper administratorPoMapper;
    @Override
    public AdministratorPo getAdminInfoByPuid(int ppUid) {
        AdministratorPoExample administratorPoExample = new AdministratorPoExample();
        administratorPoExample.createCriteria().andPpUidEqualTo(ppUid);
        List<AdministratorPo> administratorPos = administratorPoMapper.selectByExample(administratorPoExample);
        if (administratorPos == null || administratorPos.size() == 0) {
            logger.debug("getAdminInfoByPuid -> 教师信息为空，puid = " + ppUid);
            return null;
        }
        if (administratorPos.size() == 1) {
            return administratorPos.get(0);
        }
        logger.warn("getAdminInfoByPuid -> 教师信息不唯一，puid = " + ppUid);
        return null;
    }

    @Override
    public boolean isAdminExist(int ppUid) {
        AdministratorPoExample administratorPoExample = new AdministratorPoExample();
        administratorPoExample.createCriteria().andPpUidEqualTo(ppUid);
        return administratorPoMapper.countByExample(administratorPoExample) > 0;
    }
}
