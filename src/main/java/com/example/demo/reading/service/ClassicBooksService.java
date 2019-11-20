package com.example.demo.reading.service;

import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.reading.model.po.ClassicBooks;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassicBooksService {
    /**
     * 获得所有的显示的图书资源
     *
     * @param classicBooksPageBean
     */
    void getClassicBooks(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 获取拓展阅读书目
     * @param classicBooksPageBean
     */
    void getExpandingReadingBooks(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 添加经典图书
     *
     * @param classicBooks
     * @return
     */
    Boolean addClassicBookInfo(ClassicBooks classicBooks, String essayId);

    Boolean addClassicBookInfo(ClassicBooks classicBooks);
    /**
     * 批量导入图书
     *
     * @param classicBooks
     * @return
     */
    Boolean importClassicBooks(List<ClassicBooks> classicBooks);

    /**
     * 给图书增加封面
     *
     * @param stringMap
     * @param classicBooks
     */
    void bookChooseCover(Map<String, String> stringMap, List<ClassicBooks> classicBooks);

    /**
     * 检查图书是否重复
     *
     * @param classicBooks
     * @return
     */
    List<ClassicBooks> checkIsRepeat(List<ClassicBooks> classicBooks);

    /**
     * 修改经典图书
     *
     * @param classicBooks
     * @return
     */
    Boolean modifyClassicBook(ClassicBooks classicBooks);

    /**
     * 通过Id值获得相应的图书
     *
     * @param id
     * @return
     */
    ClassicBooks getClassicBookById(Integer id);

    /**
     * 图书分类
     *
     * @param procClassId
     * @return
     */
    String getBookClassifyName(String procClassId);

    /**
     * 给图书设置隐藏属性
     *
     * @param classicBooks
     * @return
     */
    Boolean hideAndShowClassicBook(ClassicBooks classicBooks);

    /**
     * 通过分类查找图书
     *
     * @param classicBooksPageBean
     * @param book_classification
     */
    void getClassicBooksByClassify(PageBean<ClassicBooks> classicBooksPageBean, String book_classification);

    /**
     * 获得分类对应的中图分类号
     *
     * @param bookClassify
     * @return
     */
    String handleBookClasify(String bookClassify);

    /**
     * 调整分类id对应的图书分类名
     *
     * @param classicBooksPageBean
     */
    void handleBookClasify(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 获得所有可以显示的图书
     *
     * @return
     */
    List<ClassicBooks> getAllEssayBooksByIsdisplay();

    /**
     * 通过resource_id获得相应的图书
     *
     * @param resource_id
     * @return
     */
    ClassicBooks getClassicBookByResourceId(String resource_id);

    /**
     * 通过条件查找图书
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
     * 获得返回信息
     *
     * @param param
     * @param classicBookList
     * @return
     */
    String getReturnMessage(String param, List<ClassicBooks> classicBookList);

    /**
     * 删除图书
     *
     * @param classicBooks
     * @return
     */
    Boolean delClassicBook(ClassicBooks classicBooks);

    /**
     * 获得分类的图书资源
     *
     * @param classicBooksPageBean
     * @param param
     */
    void getClassicBooks(PageBean<ClassicBooks> classicBooksPageBean, String param);

    /**
     * 根据搜索分类获得图书
     *
     * @param searchBooks
     * @param classicBooksPageBean
     * @param meants
     */
    void getClassicBooksBySearchClassify(String searchBooks, PageBean<ClassicBooks> classicBooksPageBean, String meants);

    /**
     * 检测
     *
     * @param classicBooks
     * @return
     */
    List<String> checkBookClassifyIsExist(List<ClassicBooks> classicBooks);

    /**
     * 获得图书
     *
     * @param classicBooksPageBean
     */
    void getClassicBooksByDisplay(PageBean<ClassicBooks> classicBooksPageBean);

    /**
     * 更新点击次数
     *
     * @param resourceId
     * @param procQuote
     */
    void updateClickCounts(String resourceId, Integer procQuote);

    /**
     * 根据书名匹配相应的pdf图书
     *
     * @param pdfStringMap
     * @param classicBooks
     */
    void bookNameChooseBook(Map<String, String> pdfStringMap, List<ClassicBooks> classicBooks);

    /**
     * 根据书名匹配相应的文件
     * @param pdfStringMap
     * @param classicBooks
     * @param sign
     */
    void setBookEnclosurePath(Map<String, String> pdfStringMap, List<ClassicBooks> classicBooks, String sign);

    /**
     * 根据分类和书名查找信息
     * @param book_name
     * @param bookClassification
     * @return
     */
    PageBean getByNameAndClassification(PageBean<ClassicBooks> classicBooksPageBean, String book_name, int bookClassification);

    /**
     * 前端获取显示活动对应书目
     * @param bookClassifyId
     * @param book_classification
     * @return
     */
    List<ClassicBooks> getdisplayEsaayBook(String bookClassifyId, int book_classification);

//    void UpPdf();
}
