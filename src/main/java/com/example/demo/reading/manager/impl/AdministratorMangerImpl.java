package com.example.demo.reading.manager.impl;

import com.dayainfo.common.util.EncodeUtils;
import com.dayainfo.common.util.JsonMapper;
import com.example.demo.reading.manager.AdministratorManger;
import com.example.demo.reading.mapper.AdministratorPoMapper;
import com.example.demo.reading.model.po.AdministratorPo;
import com.example.demo.reading.model.po.AdministratorPoExample;
import com.duxiu.cxds.api.client.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/11/1.
 */
@Service
public class AdministratorMangerImpl implements AdministratorManger {

    private static final Logger logger = LoggerFactory.getLogger(AdministratorMangerImpl.class);

//    public static final String PW_PATTERN = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";
    public static final String PW_PATTERN = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*()_+`\\-={}\\[\\]:\";'<>?,.\\/]).{8,}$";


    private AdministratorPoExample administratorPoExample;

    @Autowired
    private AdministratorPoMapper administratorPoMapper;

    @Override
    public AdministratorPo queryAdminByIdAndPwd(String userName, String password) {
        administratorPoExample = new AdministratorPoExample();
        administratorPoExample.createCriteria().andPhoneEqualTo(userName).andPpPwdEqualTo(password);
        List<AdministratorPo> result = administratorPoMapper.selectByExample(administratorPoExample);
        int size = 0;
        if (result != null && !result.isEmpty() && (size = result.size()) == 1) {
            return result.get(0);
        } else if (size > 1) {
            logger.error("queryAdminByIdAndPwd -> 管理员信息不唯一， 过滤条件 = " + userName);
        }
        return null;
    }

    @Override
    public List<AdministratorPo> queryAllAdmin() {
        administratorPoExample = new AdministratorPoExample();
        List<AdministratorPo> result = administratorPoMapper.selectByExample(administratorPoExample);
        return result;
    }

    @Override
    public String addUser(String userInfoStr) {
        userInfoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(userInfoStr));
        AdministratorPo administratorPo = new JsonMapper().fromJson(userInfoStr,AdministratorPo.class);
        administratorPoExample = new AdministratorPoExample();
        administratorPoExample.createCriteria().andPhoneEqualTo(administratorPo.getPhone());
        List<AdministratorPo> result = administratorPoMapper.selectByExample(administratorPoExample);
        if (result.size()>0){
            return "1003";   //账号已存在
        }
        if(!administratorPo.getPpPwd().matches(PW_PATTERN)){
            return "1004"; //新密码的长度须大于8位，含字母（大小写）、数字及符号组合
        }
        String pwd_md5 = Md5Utils.md5(administratorPo.getPpPwd());
        administratorPo.setPpPwd(pwd_md5);
        int count = administratorPoMapper.insert(administratorPo);
        if (count == 1){
            return "1001";  //新增成功
        }
        return "1002";  //新增失败
    }

    @Override
    public String deleteUser(int id) {
        int count = administratorPoMapper.deleteByPrimaryKey(id);
        if (count == 1){
            return "1001";  //删除成功
        }else {
            return "1002";
        }
    }

    @Override
    public AdministratorPo getAdminById(int id) {
        AdministratorPo administratorPo = administratorPoMapper.selectByPrimaryKey(id);
        return administratorPo;
    }

    @Override
    public String updateUser(String userInfoStr) {
        userInfoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(userInfoStr));
        AdministratorPo administratorPo = new JsonMapper().fromJson(userInfoStr,AdministratorPo.class);
        if(!administratorPo.getPpPwd().matches(PW_PATTERN)){
            return "1004"; //新密码的长度须大于8位，含字母（大小写）、数字及符号组合
        }
        String pwd_Md5 = Md5Utils.md5(administratorPo.getPpPwd());
        administratorPo.setPpPwd(pwd_Md5);
        int count = administratorPoMapper.updateByPrimaryKeySelective(administratorPo);
        if(count == 1){
            return "1001";  //修改成功
        }
        return "1002"; //修改失败
    }


}
