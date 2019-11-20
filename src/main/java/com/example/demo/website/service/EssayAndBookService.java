package com.example.demo.website.service;

import com.example.demo.essay.model.po.EssayInfoHistoryPo;

/**
 * Created by admin on 2019/10/11.
 * 用来处理设计活动和书本两个模块的逻辑层  避免循环依赖
 */
public interface EssayAndBookService {

    int insertEssayHistory(String essayInfoHistoryPoStr);
}
