package com.example.demo.reading.service;


import com.example.demo.reading.model.bo.BookClassificationBo;
import com.example.demo.reading.model.bo.BookClassificationMapBo;
import com.example.demo.reading.model.po.BookClassificationPo;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface BookClassificationService {
    /**
     * 获得所有分类信息
     *
     * @return
     */
    List<BookClassificationPo> getAllClassificationInfos();

    /**
     * 初始化图书分类的map
     */
    void initBookClassifyMap();

    /**
     * 添加新的图书分类
     *
     * @param bookClassificationPo
     * @return
     */
    Boolean addNewBookClassification(BookClassificationPo bookClassificationPo);

    /**
     * 获得相应的分类
     *
     * @return
     */
    List<BookClassificationBo> handleBookClassification();

    /**
     * 动态获得相应的分类
     *
     * @return
     */
    BookClassificationMapBo trendGetBookClassificationMap();

    /**
     * 修改图书分类属性
     *
     * @param bookClassificationPo
     * @return
     */
    Boolean modifyBookClassify(BookClassificationPo bookClassificationPo);

    /**
     * 删除图书分类
     *
     * @param bookClassificationPo
     * @return
     */
    Boolean delBookClassify(BookClassificationPo bookClassificationPo);

    /**
     * 置顶图书分类
     *
     * @param bookClassificationPo
     * @return
     */
    Boolean topBookClassify(BookClassificationPo bookClassificationPo);

    /**
     * 检测分类是否存在
     *
     * @param procClassId
     * @return
     */
    Boolean checkIsBookClassifyIsExist(String procClassId);

    /**
     * 通过分类id
     *
     * @param bookClassificationMapBo
     * @param bookClassificationPo
     * @return
     */
    List<BookClassificationPo> getBookClassifyByParentId(Map<String, BookClassificationPo> bookClassificationMapBo, BookClassificationPo bookClassificationPo);

}
