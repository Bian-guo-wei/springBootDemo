/*
*
* ClassicBooksMapper.java
* Copyright(C) 1993-2018 超星公司
* @date 2019-10-14
*/
package com.example.demo.reading.mapper;

import com.example.demo.reading.model.po.ClassicBooks;
import com.example.demo.reading.model.po.ClassicBooksExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ClassicBooksMapper {
    int countByExample(ClassicBooksExample example);

    int deleteByExample(ClassicBooksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassicBooks record);

    int insertSelective(ClassicBooks record);

    List<ClassicBooks> selectByExample(ClassicBooksExample example);

    ClassicBooks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassicBooks record, @Param("example") ClassicBooksExample example);

    int updateByExample(@Param("record") ClassicBooks record, @Param("example") ClassicBooksExample example);

    int updateByPrimaryKeySelective(ClassicBooks record);

    int updateByPrimaryKey(ClassicBooks record);



    List<ClassicBooks> selectByNameAndClassification(@Param("bookName") String book_name, @Param("bookClassification") int book_classification);

    List<ClassicBooks> selectBybookClassifyAndbook_classification(@Param("bookClassify") String bookClassifyId, @Param("book_classification") int book_classification);

    List<ClassicBooks> selectByUuid(@Param("uuid") String Uuid);
}