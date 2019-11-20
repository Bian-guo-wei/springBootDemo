package com.example.demo.essay.service;

import com.example.demo.essay.model.vo.EssaysIndexVo;

import javax.servlet.http.HttpServletRequest;

public interface EssayInfoService {
    String orderEssay(HttpServletRequest request, String essayInfoPoStr);
    String deleteEssay(HttpServletRequest request, String essayInfoPoStr);
    String modifyEssay(String essayInfoPoStr);
    /**
     * 获取云阅读平台移动端首页
     *
     * @return vo
     */
    EssaysIndexVo getMobileIndex();

    /**
     * 根据书本id获取对应的活动，并将数据处理
     * @param resourceId
     * @return
     */
    String getEssayByResourceId(String resourceId);

    Boolean setShow(String essayInfoHistoryPoStr, int id);
}
