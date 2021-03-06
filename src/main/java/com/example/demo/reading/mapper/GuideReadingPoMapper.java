package com.example.demo.reading.mapper;

import com.example.demo.reading.model.po.GuideReadingPo;
import com.example.demo.reading.model.po.GuideReadingPoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GuideReadingPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int countByExample(GuideReadingPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int deleteByExample(GuideReadingPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int insert(GuideReadingPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int insertSelective(GuideReadingPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    List<GuideReadingPo> selectByExampleWithBLOBs(GuideReadingPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    List<GuideReadingPo> selectByExample();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    GuideReadingPo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") GuideReadingPo record, @Param("example") GuideReadingPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") GuideReadingPo record, @Param("example") GuideReadingPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int updateByExample(@Param("record") GuideReadingPo record, @Param("example") GuideReadingPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int updateByPrimaryKeySelective(GuideReadingPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(GuideReadingPo record);
}