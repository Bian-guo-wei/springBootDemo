package com.example.demo.essay.mapper;

import com.example.demo.essay.model.po.ClickCountPo;
import com.example.demo.essay.model.po.ClickCountPoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ClickCountPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int countByExample(ClickCountPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int deleteByExample(ClickCountPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int insert(ClickCountPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int insertSelective(ClickCountPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    List<ClickCountPo> selectByExample(ClickCountPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    ClickCountPo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int updateByExampleSelective(@Param("record") ClickCountPo record, @Param("example") ClickCountPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int updateByExample(@Param("record") ClickCountPo record, @Param("example") ClickCountPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int updateByPrimaryKeySelective(ClickCountPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table click_count
     *
     * @mbggenerated Tue Apr 09 14:01:52 CST 2019
     */
    int updateByPrimaryKey(ClickCountPo record);
}