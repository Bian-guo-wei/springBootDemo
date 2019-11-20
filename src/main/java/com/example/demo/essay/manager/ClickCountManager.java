package com.example.demo.essay.manager;

public interface ClickCountManager {
    /**
     * 获得点击次数
     * @return
     * @param essayId
     */
    Integer getEssayClickCount(String essayId);
    /**
     * 更新点击次数
     * @param count
     * @param essayId
     */
    void updateEssayClickCount(Integer count, String essayId);
    /**
     * 处理点击次数
     * @param essayId
     */
    void handleEssayClick(String essayId);
    /**
     * 插入新的点击记录
     * @param essayId
     */
    void insertNewClickCount(String essayId);
    /**
     * 查询是否有改论文的点击记录
     * @param essayId
     * @return
     */
    Boolean selectEssayByEssayId(String essayId);
}
