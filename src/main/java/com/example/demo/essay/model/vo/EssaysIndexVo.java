package com.example.demo.essay.model.vo;


import com.example.demo.essay.model.po.EssayInfoPo;
import com.example.demo.essay.model.po.ReadingThoughtPo;

import java.util.List;

/**
 * 移动端首页
 *
 * @author ayne
 * @date 2018-07-20 13:51:13
 */
public class EssaysIndexVo {

    private List<ReadingThoughtPo> readingThoughtPoList;
    private List<EssayInfoPo> essayInfoPoList;

    @Override
    public String toString() {
        return "EssaysIndexVo{" +
                "readingThoughtPoList=" + readingThoughtPoList +
                ", essayInfoPoList=" + essayInfoPoList +
                '}';
    }

    public List<ReadingThoughtPo> getReadingThoughtPoList() {
        return readingThoughtPoList;
    }

    public void setReadingThoughtPoList(List<ReadingThoughtPo> readingThoughtPoList) {
        this.readingThoughtPoList = readingThoughtPoList;
    }

    public List<EssayInfoPo> getEssayInfoPoList() {
        return essayInfoPoList;
    }

    public void setEssayInfoPoList(List<EssayInfoPo> essayInfoPoList) {
        this.essayInfoPoList = essayInfoPoList;
    }
}
