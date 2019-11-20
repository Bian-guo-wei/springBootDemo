package com.example.demo.reading.manager;

import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.reading.model.po.ClassicBooks;

import java.util.List;

/**
 * @author admin
 */
//@Repository
public interface ClassicBooksManager {
    /**
     * 分页获取资源图书
     *
     * @param classicBooksPageBean
     */
    void getClassicBooksByPage(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 分页获取拓展阅读图书
     *
     * @param classicBooksPageBean
     */
    void getExpandingReadingBooksByPage(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 获得总的图书数量
     *
     * @param classicBooksPageBean
     */
    void getTotalBooksCount(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 增加图书记录
     *
     * @param classicBooks
     * @return
     */
    Boolean addClassicBookInfo(ClassicBooks classicBooks, String essayId);


    Boolean addClassicBookInfo(ClassicBooks classicBooks);
    /**
     * 获得数据库里面所有的图书
     *
     * @return
     */
    List<ClassicBooks> getAllClassicBooks();

    /**
     * 修改图书
     *
     * @param classicBooks
     * @return
     */
    Boolean modifyClassicBookById(ClassicBooks classicBooks);

    /**
     * 获得图书
     *
     * @param id
     * @return
     */
    ClassicBooks getOneClassicBook(Integer id);

    /**
     * 修改图书的display值
     *
     * @param id
     * @param isDisplay
     * @return
     */
    Boolean modifyDisplayById(Integer id, Integer isDisplay);

    /**
     * 通过条件查找图书
     *
     * @param classicBooksPageBean
     * @param bookClassify
     */
    void getClassicBooksByPage(PageBean<ClassicBooks> classicBooksPageBean, String bookClassify);

    /**
     * 通过条件查找图书数量
     *
     * @param classicBooksPageBean
     * @param bookClassify
     */
    void getTotalBooksCount(PageBean<ClassicBooks> classicBooksPageBean, String bookClassify);

    /**
     * 显示所有的图书
     *
     * @return
     */
    List<ClassicBooks> getAllClassicBooksByDisplay();

    /**
     * 通过resource_id获得相应图书
     *
     * @param resource_id
     * @return
     */
    ClassicBooks getOneClassicBookByResourceId(String resource_id);

    /**
     * 根据标题查找图书
     *
     * @param searchBooks
     * @return
     */
    List<ClassicBooks> getClassicBooksLikeTitle(String searchBooks);

    /**
     * 根据作者查找图书
     *
     * @param searchBooks
     * @return
     */
    List<ClassicBooks> getClassicBooksLikeAuthor(String searchBooks);

    /**
     * 根据关键词查找图书
     *
     * @param searchBooks
     * @return
     */
    List<ClassicBooks> getClassicBooksLikeKeyword(String searchBooks);

    /**
     * 删除图书
     *
     * @param id
     * @return
     */
    Boolean delClassicBookById(Integer id);

    /**
     * 根据作者查找图书
     *
     * @param classicBooksPageBean
     * @param searchBooks
     */
    void getClassicBooksLikeAuthor(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks);

    /**
     * '根据标题查找图书
     *
     * @param classicBooksPageBean
     * @param searchBooks
     */
    void getClassicBooksLikeTitle(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks);

    /**
     * 根据关键词查找图书
     *
     * @param classicBooksPageBean
     * @param searchBooks
     */
    void getClassicBooksLikeKeyword(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks);

    /**
     * 根据标题查找总量
     *
     * @param classicBooksPageBean
     * @param searchBooks
     */
    void getClassicBooksCountLikeTitle(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks);

    /**
     * 根据作者查找总量
     *
     * @param classicBooksPageBean
     * @param searchBooks
     */
    void getClassicBooksCountLikeAuthor(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks);

    /**
     * 根据关键字查找总量
     *
     * @param classicBooksPageBean
     * @param searchBooks
     */
    void getClassicBooksCountLikeKeyword(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks);

    /**
     * 根据分类名称查找相应的数量
     *
     * @param classificationId
     * @return
     */
    int getTotalBooksCount(String classificationId);

    /**
     * 通过分类获得图书
     *
     * @param classicBooksPageBean
     */
    void getClassicBooksByPageByDisplay(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 通过分类获得图书数量
     *
     * @param classicBooksPageBean
     */
    void getTotalBooksCountByDisplay(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 更新点击次数
     *
     * @param resourceId
     * @param procQuote
     */
    void updateClickCounts(String resourceId, Integer procQuote);

    PageBean getByNameAndClassification(PageBean<ClassicBooks> classicBooksPageBean, String book_name, int bookClassification);

    List<ClassicBooks> getdisplayEsaayBook(String bookClassifyId, int book_classification);

    PageBean getBooksByUuid(PageBean<ClassicBooks> classicBooksPageBean, String uuid);


}
