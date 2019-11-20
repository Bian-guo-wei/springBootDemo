package com.example.demo.essay.mapper;

import com.example.demo.essay.model.po.EssayInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2019/9/24.
 */
@Mapper
public interface CustomMapper {
    /**
     * 获取非前台展示的活动
     * @return
     */
    List<EssayInfoPo> selectByStatus();

    /**
     * 根据书本的resourceid获取对应活动
     * @param ResourceId
     * @return
     */
    List<EssayInfoPo> selectByResourceId(@Param("resourceid") String ResourceId);

    List<EssayInfoPo> selectByEssayName(@Param("EssayName") String EssayName);
}
