package com.example.demo.reading.manager;

import com.example.demo.reading.model.po.AdministratorPo;

import java.util.List;

/**
 * Created by admin on 2019/11/1.
 */
public interface AdministratorManger {
    AdministratorPo queryAdminByIdAndPwd(String userName, String password);

    List<AdministratorPo> queryAllAdmin();

    String addUser(String userInfoStr);

    String deleteUser(int id);

    AdministratorPo getAdminById(int id);

    String updateUser(String userInfoStr);
}
