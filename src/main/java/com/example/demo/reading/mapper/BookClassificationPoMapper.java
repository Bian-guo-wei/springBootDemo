/*
 *
 * BookClassificationPoMapper.java
 * Copyright(C) 1993-2018 超星公司
 * @date 2018-10-30
 */
package com.example.demo.reading.mapper;

import com.example.demo.reading.model.po.BookClassificationPo;
import com.example.demo.reading.model.po.BookClassificationPoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BookClassificationPoMapper {
    int countByExample(BookClassificationPoExample example);

    int deleteByExample(BookClassificationPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookClassificationPo record);

    int insertSelective(BookClassificationPo record);

    List<BookClassificationPo> selectByExample(BookClassificationPoExample example);

    BookClassificationPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookClassificationPo record, @Param("example") BookClassificationPoExample example);

    int updateByExample(@Param("record") BookClassificationPo record, @Param("example") BookClassificationPoExample example);

    int updateByPrimaryKeySelective(BookClassificationPo record);

    int updateByPrimaryKey(BookClassificationPo record);

    String getClassfiyNameByClassfiyId(@Param("classfiyId") String classfiyId);
}