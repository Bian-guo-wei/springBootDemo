package com.example.demo.essay.mapper;

import com.example.demo.essay.model.po.EssayInfoHistoryPo;
import com.example.demo.essay.model.po.EssayInfoHistoryPoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EssayInfoHistoryPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int countByExample(EssayInfoHistoryPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int deleteByExample(EssayInfoHistoryPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int insert(EssayInfoHistoryPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int insertSelective(EssayInfoHistoryPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    List<EssayInfoHistoryPo> selectByExample(EssayInfoHistoryPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    EssayInfoHistoryPo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int updateByExampleSelective(@Param("record") EssayInfoHistoryPo record, @Param("example") EssayInfoHistoryPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int updateByExample(@Param("record") EssayInfoHistoryPo record, @Param("example") EssayInfoHistoryPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int updateByPrimaryKeySelective(EssayInfoHistoryPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay_info_history
     *
     * @mbggenerated Fri Oct 11 15:15:35 CST 2019
     */
    int updateByPrimaryKey(EssayInfoHistoryPo record);
}