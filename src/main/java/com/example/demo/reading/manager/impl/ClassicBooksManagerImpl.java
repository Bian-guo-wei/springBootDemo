package com.example.demo.reading.manager.impl;

import com.dayainfo.lib.search.model.PageBean;
import com.dayainfo.lib.search.util.PageHelperUtil;
import com.example.demo.essay.manager.EssayInfoManager;
import com.example.demo.essay.mapper.CustomMapper;
import com.example.demo.essay.model.po.EssayInfoPo;
import com.example.demo.reading.constant.ClassicBooksConstant;
import com.example.demo.reading.manager.ClassicBooksManager;
import com.example.demo.reading.mapper.BookssayInfoMapperPoMapper;
import com.example.demo.reading.mapper.ClassicBooksMapper;
import com.example.demo.reading.model.po.ClassicBooks;
import com.example.demo.reading.model.po.ClassicBooksExample;
import com.example.demo.reading.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author admin
 */
@Service
public class ClassicBooksManagerImpl implements ClassicBooksManager {
    @Autowired
    private ClassicBooksMapper classicBooksMapper;
    @Autowired
    private BookssayInfoMapperPoMapper bookssayInfoMapperPoMapper;
    @Autowired
    private CustomMapper customMapper;
    @Autowired
    private EssayInfoManager essayInfoManager;

    @Override
    public void getClassicBooksByPage(PageBean<ClassicBooks> classicBooksPageBean) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria();
        classicBooksExample.setOrderByClause("gmt_create desc");
//        classicBooksExample.setOrderByClause("proc_quote desc");
        PageHelperUtil.startPage(classicBooksPageBean);
        List<ClassicBooks> classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        classicBooksPageBean.setList(classicBooks);
    }

    @Override
    public void getExpandingReadingBooksByPage(PageBean<ClassicBooks> classicBooksPageBean) {
        List<String> list = bookssayInfoMapperPoMapper.getResourceId(2);  //获取对应的resourceId
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andResourceIdIn(list);
        classicBooksExample.setOrderByClause("gmt_create desc");
//        classicBooksExample.setOrderByClause("proc_quote desc");
        List<ClassicBooks> classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        classicBooksPageBean.setTotalData(classicBooks.size());


        PageHelperUtil.startPage(classicBooksPageBean);
        classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        classicBooksPageBean.setList(classicBooks);

//        ClassicBooksExample.Criteria criteria = classicBooksExample.createCriteria();
//        if (StringUtils.isNotBlank(book_classification)) {
//            criteria.andProcClassIdLike("%" + book_classification + "%");
//        }
//        int count = classicBooksMapper.countByExample(classicBooksExample);
//        classicBooksPageBean.setTotalData(count);
    }


    @Override
    public void getTotalBooksCount(PageBean<ClassicBooks> classicBooksPageBean) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria();
        int count = classicBooksMapper.countByExample(classicBooksExample);
        classicBooksPageBean.setTotalData(count);
    }

    @Override
    public Boolean addClassicBookInfo(ClassicBooks classicBooks, String essayId) {
        if (null == classicBooks.getGmtCreate()) {
            classicBooks.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        }

        classicBooks.setResourceId(UUID.randomUUID() + ClassicBooksConstant.UUID_TIMESTAMP_SEPARATOR + System.currentTimeMillis());

        List essayIdList = StringUtils.spliteByComma(essayId);

        int count = classicBooksMapper.insertSelective(classicBooks);
        if (count > 0) {
            for (int i = 0; i < essayIdList.size(); i++) {
                bookssayInfoMapperPoMapper.insert(classicBooks.getResourceId(), (String) essayIdList.get(i));
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean addClassicBookInfo(ClassicBooks classicBooks) {
        if (null == classicBooks.getGmtCreate()) {
            classicBooks.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        }
        classicBooks.setResourceId(UUID.randomUUID() + ClassicBooksConstant.UUID_TIMESTAMP_SEPARATOR + System.currentTimeMillis());

        //针对于批量导入
        if(classicBooks.getBasicContact()!= null){
            List UUidList = getUUidByEssayName(classicBooks.getBasicContact());
            for (Object uuid: UUidList){
                bookssayInfoMapperPoMapper.insert(classicBooks.getResourceId(), (String) uuid);
            }
        }


        int count = classicBooksMapper.insertSelective(classicBooks);
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    //解析活动名称，获取对应UUid
    private List getUUidByEssayName(String EssayNames){
        List EssayList = StringUtils.spliteByComma(EssayNames);
        List UuidList = new ArrayList();
        for (int i = 0; i<EssayList.size(); i++){
            List<EssayInfoPo> EssayInfoList = essayInfoManager.getEssayByName((String) EssayList.get(i));
            for(EssayInfoPo essayInfoPo : EssayInfoList){
                if (essayInfoPo.getUuid() != null){
                    UuidList.add(essayInfoPo.getUuid());
                }
            }
        }
        return UuidList;
    }

    @Override
    public List<ClassicBooks> getAllClassicBooks() {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria();
        List<ClassicBooks> classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        return classicBooks;
    }

    @Override
    public Boolean modifyClassicBookById(ClassicBooks classicBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andIdEqualTo(classicBooks.getId());
        int count = classicBooksMapper.updateByExampleSelective(classicBooks, classicBooksExample);
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public ClassicBooks getOneClassicBook(Integer id) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andIdEqualTo(id);
        return classicBooksMapper.selectByExample(classicBooksExample).get(0);
    }

    @Override
    public Boolean modifyDisplayById(Integer id, Integer isDisplay) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andIdEqualTo(id);
        ClassicBooks classicBook = new ClassicBooks();
        classicBook.setIsDisplay(isDisplay);
        classicBook.setId(id);
        classicBook.setGmtModified(new Timestamp(System.currentTimeMillis()));
        int count = classicBooksMapper.updateByExampleSelective(classicBook, classicBooksExample);
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public void getClassicBooksByPage(PageBean<ClassicBooks> classicBooksPageBean, String book_classification) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        List<String> list = bookssayInfoMapperPoMapper.getResourceId(1);   //获取当前显示活动对应的resourceId
        if (StringUtils.isNotBlank(book_classification)) {
            classicBooksExample.createCriteria().andProcClassIdEqualTo(book_classification).andResourceIdIn(list);
        } else {
            classicBooksExample.createCriteria().andResourceIdIn(list);
        }
        PageHelperUtil.startPage(classicBooksPageBean);

        List<ClassicBooks> classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        classicBooksPageBean.setList(classicBooks);
    }

    @Override
    public void getTotalBooksCount(PageBean<ClassicBooks> classicBooksPageBean, String book_classification) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        ClassicBooksExample.Criteria criteria = classicBooksExample.createCriteria();
        if (StringUtils.isNotBlank(book_classification)) {
            criteria.andProcClassIdLike("%" + book_classification + "%");
        }
        int count = classicBooksMapper.countByExample(classicBooksExample);
        classicBooksPageBean.setTotalData(count);
    }

    @Override
    public List<ClassicBooks> getAllClassicBooksByDisplay() {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andIsDisplayEqualTo(0);
//        classicBooksExample.setOrderByClause("gmt_create desc");
        classicBooksExample.setOrderByClause("proc_quote desc");
        return classicBooksMapper.selectByExample(classicBooksExample);
    }

    @Override
    public ClassicBooks getOneClassicBookByResourceId(String resource_id) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andResourceIdEqualTo(resource_id);
        return classicBooksMapper.selectByExample(classicBooksExample).get(0);
    }

    @Override
    public List<ClassicBooks> getClassicBooksLikeTitle(String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicTitleLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
//        classicBooksExample.setOrderByClause("gmt_create desc");
        classicBooksExample.setOrderByClause("proc_quote desc");
        return classicBooksMapper.selectByExample(classicBooksExample);
    }

    @Override
    public List<ClassicBooks> getClassicBooksLikeAuthor(String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicCreatorLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
//        classicBooksExample.setOrderByClause("gmt_create desc");
        classicBooksExample.setOrderByClause("proc_quote desc");
        return classicBooksMapper.selectByExample(classicBooksExample);
    }

    @Override
    public List<ClassicBooks> getClassicBooksLikeKeyword(String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicKeywordLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
//        classicBooksExample.setOrderByClause("gmt_create desc");
        classicBooksExample.setOrderByClause("proc_quote desc");
        return classicBooksMapper.selectByExample(classicBooksExample);
    }

    @Override
    public Boolean delClassicBookById(Integer id) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andIdEqualTo(id);
        int count = classicBooksMapper.deleteByExample(classicBooksExample);
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public void getClassicBooksLikeAuthor(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicCreatorLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
//        classicBooksExample.setOrderByClause("gmt_create desc");
        classicBooksExample.setOrderByClause("proc_quote desc");
        PageHelperUtil.startPage(classicBooksPageBean);
        List<ClassicBooks> classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        classicBooksPageBean.setList(classicBooks);
    }

    @Override
    public void getClassicBooksLikeTitle(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicTitleLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
//        classicBooksExample.setOrderByClause("gmt_create desc");
        classicBooksExample.setOrderByClause("proc_quote desc");
        PageHelperUtil.startPage(classicBooksPageBean);
        List<ClassicBooks> classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        classicBooksPageBean.setList(classicBooks);
    }

    @Override
    public void getClassicBooksLikeKeyword(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicKeywordLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
//        classicBooksExample.setOrderByClause("gmt_create desc");
        classicBooksExample.setOrderByClause("proc_quote desc");
        PageHelperUtil.startPage(classicBooksPageBean);
        List<ClassicBooks> classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        classicBooksPageBean.setList(classicBooks);
    }

    @Override
    public void getClassicBooksCountLikeTitle(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicTitleLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
        int count = classicBooksMapper.countByExample(classicBooksExample);
        classicBooksPageBean.setTotalData(count);
    }

    @Override
    public void getClassicBooksCountLikeAuthor(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicCreatorLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
        int count = classicBooksMapper.countByExample(classicBooksExample);
        classicBooksPageBean.setTotalData(count);
    }

    @Override
    public void getClassicBooksCountLikeKeyword(PageBean<ClassicBooks> classicBooksPageBean, String searchBooks) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andBasicKeywordLike("%" + searchBooks + "%").andIsDisplayEqualTo(ClassicBooksConstant.CLASSICBOOKS_IS_DISPLAY);
        int count = classicBooksMapper.countByExample(classicBooksExample);
        classicBooksPageBean.setTotalData(count);
    }

    @Override
    public int getTotalBooksCount(String classificationId) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andProcClassIdEqualTo(classificationId);
        return classicBooksMapper.countByExample(classicBooksExample);
    }

    @Override
    public void getClassicBooksByPageByDisplay(PageBean<ClassicBooks> classicBooksPageBean) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andIsDisplayEqualTo(0);
//        classicBooksExample.setOrderByClause("gmt_create desc");
        classicBooksExample.setOrderByClause("proc_quote desc");
        PageHelperUtil.startPage(classicBooksPageBean);
        List<ClassicBooks> classicBooks = classicBooksMapper.selectByExample(classicBooksExample);
        classicBooksPageBean.setList(classicBooks);


    }

    @Override
    public void getTotalBooksCountByDisplay(PageBean<ClassicBooks> classicBooksPageBean) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andIsDisplayEqualTo(0);
        int count = classicBooksMapper.countByExample(classicBooksExample);
        classicBooksPageBean.setTotalData(count);
    }

    @Override
    public void updateClickCounts(String resourceId, Integer procQuote) {
        ClassicBooksExample classicBooksExample = new ClassicBooksExample();
        classicBooksExample.createCriteria().andResourceIdEqualTo(resourceId);
        ClassicBooks classicBooks = new ClassicBooks();
        classicBooks.setProcQuote(procQuote);
        classicBooksMapper.updateByExampleSelective(classicBooks, classicBooksExample);
    }

    @Override
    public PageBean getByNameAndClassification(PageBean<ClassicBooks> classicBooksPageBean, String book_name, int bookClassification) {
        List<ClassicBooks> list = classicBooksMapper.selectByNameAndClassification(book_name,bookClassification);
        classicBooksPageBean.setTotalData(list.size());

        PageHelperUtil.startPage(classicBooksPageBean);
        list = classicBooksMapper.selectByNameAndClassification(book_name,bookClassification);
        classicBooksPageBean.setList(list);
        return classicBooksPageBean;
    }

    @Override
    public List<ClassicBooks> getdisplayEsaayBook(String bookClassifyId, int book_classification) {
        return classicBooksMapper.selectBybookClassifyAndbook_classification(bookClassifyId, book_classification);
    }

    @Override
    public PageBean getBooksByUuid(PageBean<ClassicBooks> classicBooksPageBean, String uuid) {
        List<ClassicBooks> list = classicBooksMapper.selectByUuid(uuid);
        classicBooksPageBean.setTotalData(list.size());

        PageHelperUtil.startPage(classicBooksPageBean);
        list = classicBooksMapper.selectByUuid(uuid);
        classicBooksPageBean.setList(list);
        return classicBooksPageBean;
    }
}
