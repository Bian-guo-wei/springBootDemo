/*
*
* BookssayInfoMapperPoMapper.java
* Copyright(C) 1993-2018 超星公司
* @date 2019-08-19
*/
package com.example.demo.reading.mapper;

import com.example.demo.reading.model.po.BookssayInfoMapperPo;
import com.example.demo.reading.model.po.BookssayInfoMapperPoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BookssayInfoMapperPoMapper {
    int countByExample(BookssayInfoMapperPoExample example);

    int deleteByExample(BookssayInfoMapperPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(@Param("resourceid") String resourceId, @Param("uuid") String essayId);

    int insertSelective(BookssayInfoMapperPo record);

    List<BookssayInfoMapperPo> selectByExample(BookssayInfoMapperPoExample example);

    BookssayInfoMapperPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookssayInfoMapperPo record, @Param("example") BookssayInfoMapperPoExample example);

    int updateByExample(@Param("record") BookssayInfoMapperPo record, @Param("example") BookssayInfoMapperPoExample example);

    int updateByPrimaryKeySelective(BookssayInfoMapperPo record);

    int updateByPrimaryKey(BookssayInfoMapperPo record);

    List<String> getResourceId(@Param("sign") int sign);
}