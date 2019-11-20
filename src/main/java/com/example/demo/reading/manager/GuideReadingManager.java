package com.example.demo.reading.manager;

import com.example.demo.reading.model.po.GuideReadingPo;

import java.util.List;

/**
 * Created by admin on 2019/9/25.
 */
public interface GuideReadingManager {

    //添加专家导读表中添加数据
    Boolean insert(GuideReadingPo guideReadingPo);

    Boolean update(GuideReadingPo guideReadingPo);

    List<GuideReadingPo> getInfo();
}
