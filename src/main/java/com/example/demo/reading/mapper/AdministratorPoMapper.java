/*
*
* AdministratorPoMapper.java
* Copyright(C) 1993-2018 超星公司
* @date 2019-10-15
*/
package com.example.demo.reading.mapper;

import com.example.demo.reading.model.po.AdministratorPo;
import com.example.demo.reading.model.po.AdministratorPoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AdministratorPoMapper {
    int countByExample(AdministratorPoExample example);

    int deleteByExample(AdministratorPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdministratorPo record);

    int insertSelective(AdministratorPo record);

    List<AdministratorPo> selectByExample(AdministratorPoExample example);

    AdministratorPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdministratorPo record, @Param("example") AdministratorPoExample example);

    int updateByExample(@Param("record") AdministratorPo record, @Param("example") AdministratorPoExample example);

    int updateByPrimaryKeySelective(AdministratorPo record);

    int updateByPrimaryKey(AdministratorPo record);
}