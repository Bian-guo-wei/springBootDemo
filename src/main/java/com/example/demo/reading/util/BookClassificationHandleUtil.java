package com.example.demo.reading.util;


import com.example.demo.reading.constant.BookClassificationConstant;

import java.util.Map;

/**
 * 因为图书分类是写在一个constant的map里面这里做处理转换
 *
 * @author admin
 */
public class BookClassificationHandleUtil {
    public static String keyAndValueInterconversion(String procClassId) {
        for (Map.Entry<String, String> ele : BookClassificationConstant.bookClassifyMap.entrySet()) {
            if (procClassId.contains(ele.getKey())) {
                return ele.getValue();
            }
        }
        return null;
    }
}
