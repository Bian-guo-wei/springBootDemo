package com.example.demo.website.manager;


import com.example.demo.reading.model.po.AdministratorPo;

/**
 * @author ayne
 * @date 2019-04-02 15:57:16
 */
public interface AdminManager {

    /**
     * 查找管理员信息
     *
     * @param ppUid
     * @return
     */
    AdministratorPo getAdminInfoByPuid(int ppUid);

    /**
     * 管理员是否存在
     *
     * @param ppUid
     * @return
     */
    boolean isAdminExist(int ppUid);
}
