package com.example.demo.reading.util;

import com.dayainfo.lib.search.model.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * pagehelper组件
 *
 * @author ayne
 * @date 2018-07-03 11:29:38
 */
public class PageHelperUtil {

    private static final Logger logger = LoggerFactory.getLogger(PageHelperUtil.class);

    /**
     * 分页计算
     * 必须在进行分页的 MyBatis 查询方法前一行调用 PageHelper.startPage 静态方法，
     * <b>即<i>紧跟</i>在这个方法后的第一个MyBatis 查询方法会被进行分页。</b>
     *
     * @param pageBean 分页信息
     * @see <a href="https://pagehelper.github.io/docs/howtouse/">官网文档安全调用</a>
     */
    public static void startPage(PageBean pageBean) {
        int current = pageBean.getCurrentPage() > 0 ? pageBean.getCurrentPage() : 0;
        int end = pageBean.getEndPage() > 0 && pageBean.getEndPage() > pageBean.getCurrentPage() ? pageBean.getEndPage() : current + 1;
        int size = pageBean.getPagesize() > 0 ? pageBean.getPagesize() : 10;
        int pageSize = (end - current) * size;
        logger.debug("startPage -> pageNo = " + current + ", pageSize = " + pageSize);
        //startPage方法第一个参数为页码，而不是sql limit 语句中第一个参数， 即不是begin * size
        PageHelper.startPage(current, pageSize, false);
    }
}
