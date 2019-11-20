package com.example.demo.reading.model.bo;


import com.example.demo.reading.model.po.BookClassificationPo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public class BookClassificationMapBo {
    private Map<String, String> bookClassifyMap = new HashMap<>();
    private Map<String, BookClassificationPo> firstBookClassifyMap = new HashMap<>();
    private Map<String, BookClassificationPo> secondBookClassifyMap = new HashMap<>();
    private Map<String, BookClassificationPo> thirdBookClassifyMap = new HashMap<>();

    public Map<String, String> getBookClassifyMap() {
        return bookClassifyMap;
    }

    public void setBookClassifyMap(Map<String, String> bookClassifyMap) {
        this.bookClassifyMap = bookClassifyMap;
    }

    public Map<String, BookClassificationPo> getFirstBookClassifyMap() {
        return firstBookClassifyMap;
    }

    public void setFirstBookClassifyMap(Map<String, BookClassificationPo> firstBookClassifyMap) {
        this.firstBookClassifyMap = firstBookClassifyMap;
    }

    public Map<String, BookClassificationPo> getSecondBookClassifyMap() {
        return secondBookClassifyMap;
    }

    public void setSecondBookClassifyMap(Map<String, BookClassificationPo> secondBookClassifyMap) {
        this.secondBookClassifyMap = secondBookClassifyMap;
    }

    public Map<String, BookClassificationPo> getThirdBookClassifyMap() {
        return thirdBookClassifyMap;
    }

    public void setThirdBookClassifyMap(Map<String, BookClassificationPo> thirdBookClassifyMap) {
        this.thirdBookClassifyMap = thirdBookClassifyMap;
    }

    @Override
    public String toString() {
        return "BookClassificationMapBo{" +
                "bookClassifyMap=" + bookClassifyMap +
                ", firstBookClassifyMap=" + firstBookClassifyMap +
                ", secondBookClassifyMap=" + secondBookClassifyMap +
                ", thirdBookClassifyMap=" + thirdBookClassifyMap +
                '}';
    }
}
