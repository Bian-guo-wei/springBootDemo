package com.example.demo.reading.manager;


import com.example.demo.reading.model.po.BookClassificationPo;

import java.util.List;

/**
 * @author admin
 */
public interface BookClassificationManager {
    /**
     * 从数据库获得所有分类信息
     *
     * @return
     */
    List<BookClassificationPo> getAllClassificationInfosFromDataBase();

    /**
     * 添加新的图书分类
     *
     * @param bookClassificationPo
     * @return
     */
    Boolean addNewBookClassification(BookClassificationPo bookClassificationPo);

    /**
     * 修改图书分类信息值
     *
     * @param bookClassificationPo
     * @return
     */
    Boolean modifyBookClassification(BookClassificationPo bookClassificationPo);

    /**
     * 删除图书分类
     *
     * @param classificationId
     * @return
     */
    Boolean delBookClassificationByClassificationId(String classificationId);

    /**
     * 通过分类id值查找图书分类
     *
     * @param classificationId
     * @return
     */
    BookClassificationPo selectBookClassificationByClassificationId(String classificationId);

    /**
     * 通过ParentClassificationId查找图书分类
     *
     * @param parentClassificationId
     * @return
     */
    List<BookClassificationPo> selectBookClassificationByParentClassificationId(String parentClassificationId);

    /**
     * 检测分类是否存在
     *
     * @param procClassId
     * @return
     */
    Boolean checkIsBookClassifyIsExist(String procClassId);

    String getClassfiyNameByClassfiyId(String classfiyId);
}
