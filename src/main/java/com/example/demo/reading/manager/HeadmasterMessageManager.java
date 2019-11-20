package com.example.demo.reading.manager;

import com.example.demo.reading.model.po.HeadmasterMessagePo;

import java.util.List;

/**
 * Created by admin on 2019/9/25.
 */
public interface HeadmasterMessageManager {

    //添加专家导读表中添加数据
    Boolean insert(HeadmasterMessagePo headmasterMessagePo);

    Boolean update(HeadmasterMessagePo headmasterMessagePo);

    List<HeadmasterMessagePo> getInfo();
}
