package com.example.demo.reading.service.impl;

import com.dayainfo.common.util.JsonMapper;
import com.dayainfo.common.util.StringUtils;
import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.reading.constant.ClassicBooksConstant;
import com.example.demo.reading.constant.EssayUploadConstant;
import com.example.demo.reading.manager.ClassicBooksManager;
import com.example.demo.reading.model.bo.BookClassificationMapBo;
import com.example.demo.reading.model.po.ClassicBooks;
import com.example.demo.reading.service.BookClassificationService;
import com.example.demo.reading.service.ClassicBooksService;
import com.example.demo.reading.util.HttpClientUtil;
import com.duxiu.cxds.api.json.JSONException;
import com.duxiu.cxds.api.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Service
public class ClassicBooksServiceImpl implements ClassicBooksService {
    @Autowired
    private ClassicBooksManager classicBooksManager;
    @Autowired
    private BookClassificationService bookClassificationService;

    @Override
    public void getClassicBooks(PageBean<ClassicBooks> classicBooksPageBean) {
        classicBooksManager.getClassicBooksByPage(classicBooksPageBean);
        classicBooksManager.getTotalBooksCount(classicBooksPageBean);
    }

    @Override
    public void getExpandingReadingBooks(PageBean<ClassicBooks> classicBooksPageBean) {
        classicBooksManager.getExpandingReadingBooksByPage(classicBooksPageBean);
    }

    @Override
    public Boolean addClassicBookInfo(ClassicBooks classicBooks, String essayId) {
        return classicBooksManager.addClassicBookInfo(classicBooks, essayId);
    }

    @Override
    public Boolean addClassicBookInfo(ClassicBooks classicBooks) {
        return classicBooksManager.addClassicBookInfo(classicBooks);
    }

    @Override
    public Boolean importClassicBooks(List<ClassicBooks> classicBooks) {
        for (ClassicBooks classicBook : classicBooks) {
            classicBooksManager.addClassicBookInfo(classicBook);
        }
        return Boolean.TRUE;
    }

    @Override
    public void bookChooseCover(Map<String, String> stringMap, List<ClassicBooks> classicBooks) {
        String imgUrl = null;
        String objId = null;
        for (Map.Entry<String, String> ele : stringMap.entrySet()) {
            for (ClassicBooks classicBook : classicBooks) {
                if (ele.getKey().contains(classicBook.getBasicTitle()) && null != ele.getValue() && !ele.getValue().contains("error")) {
                    try {
                        JSONObject jsonObject = new JSONObject(ele.getValue());
                        if (jsonObject.get("objectId") != null && jsonObject.get("objectId") != "") {
                            objId = (String) jsonObject.get("objectId");
                            imgUrl = "http://p.ananas.chaoxing.com/star3/origin/" + objId + ".jpg";
                        }
//                        imgUrl = (String) jsonObject.get("img");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    classicBook.setScreenshot(imgUrl);
                }
            }
        }
    }

    @Override
    public List<ClassicBooks> checkIsRepeat(List<ClassicBooks> classicBooks) {
        List<ClassicBooks> repeatBooks = new ArrayList<>();
        List<ClassicBooks> allClassicBooks = classicBooksManager.getAllClassicBooks();
        for (ClassicBooks classicBook1 : allClassicBooks) {
            for (ClassicBooks classicBook : classicBooks) {
                    if (classicBook1.getBasicTitle().equals(classicBook.getBasicTitle())
                            && classicBook1.getBasicCreator().equals(classicBook.getBasicCreator())
                            && classicBook1.getBasicDate().equals(classicBook.getBasicDate()) ) {
                        repeatBooks.add(classicBook);
                        break;
                    }
            }
        }

        return repeatBooks;
    }

    @Override
    public Boolean modifyClassicBook(ClassicBooks classicBooks) {

        return classicBooksManager.modifyClassicBookById(classicBooks);
    }

    @Override
    public ClassicBooks getClassicBookById(Integer id) {
        return classicBooksManager.getOneClassicBook(id);
    }

    @Override
    public String getBookClassifyName(String procClassId) {
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        if (StringUtils.isNotBlank(procClassId)) {
            for (Map.Entry<String, String> ele : bookClassificationMapBo.getBookClassifyMap().entrySet()) {
                if (procClassId.contains(ele.getKey())) {
                    return ele.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public Boolean hideAndShowClassicBook(ClassicBooks classicBooks) {
        return classicBooksManager.modifyDisplayById(classicBooks.getId(), classicBooks.getIsDisplay());
    }

    @Override
    public void getClassicBooksByClassify(PageBean<ClassicBooks> classicBooksPageBean, String book_classification) {
        classicBooksManager.getClassicBooksByPage(classicBooksPageBean, book_classification);
        classicBooksManager.getTotalBooksCount(classicBooksPageBean, book_classification);
    }

    @Override
    public String handleBookClasify(String bookClassify) {
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        if (StringUtils.isNotBlank(bookClassify)) {
            for (Map.Entry<String, String> ele : bookClassificationMapBo.getBookClassifyMap().entrySet()) {
                if (ele.getValue().contains(bookClassify)) {
                    return ele.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public void handleBookClasify(PageBean<ClassicBooks> classicBooksPageBean) {
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        if (null != classicBooksPageBean) {
            for (ClassicBooks classicBook : classicBooksPageBean.getList()) {
                for (Map.Entry<String, String> ele : bookClassificationMapBo.getBookClassifyMap().entrySet()) {
                    if (StringUtils.isNotBlank(classicBook.getProcClassId())) {
                        if (classicBook.getProcClassId().contains(ele.getKey())) {
                            classicBook.setProcClassId(ele.getValue());
                        }
                    } else {
                        break;
                    }

                }
            }
        }
    }

    @Override
    public List<ClassicBooks> getAllEssayBooksByIsdisplay() {
        return classicBooksManager.getAllClassicBooksByDisplay();
    }

    @Override
    public ClassicBooks getClassicBookByResourceId(String resource_id) {
        ClassicBooks classicBooks = classicBooksManager.getOneClassicBookByResourceId(resource_id);
        classicBooks.setProcFileLink(classicBooks.getProcFileLink().replace("\r\n", ""));
        return classicBooks;
    }

    @Override
    public List<ClassicBooks> getClassicBooksLikeTitle(String searchBooks) {
        return classicBooksManager.getClassicBooksLikeTitle(searchBooks);
    }

    @Override
    public List<ClassicBooks> getClassicBooksLikeAuthor(String searchBooks) {
        return classicBooksManager.getClassicBooksLikeAuthor(searchBooks);
    }

    @Override
    public List<ClassicBooks> getClassicBooksLikeKeyword(String searchBooks) {
        return classicBooksManager.getClassicBooksLikeKeyword(searchBooks);
    }

    @Override
    public String getReturnMessage(String param, List<ClassicBooks> classicBookList) {
        List<ClassicBooks> newList = new ArrayList<>();
        //暂时替代值
        String All = ClassicBooksConstant.CLASSICBOOKS_PARAM_SEARCH;
        if (All.equals(param)) {
            return new JsonMapper().toJson(classicBookList);
        } else {
            for (ClassicBooks classicBooks : classicBookList) {
                if (StringUtils.isNotBlank(classicBooks.getProcClassId()) && classicBooks.getProcClassId().contains(param)) {
                    newList.add(classicBooks);
                }
            }
        }
        return new JsonMapper().toJson(newList);
    }

    @Override
    public Boolean delClassicBook(ClassicBooks classicBooks) {
        return classicBooksManager.delClassicBookById(classicBooks.getId());
    }

    @Override
    public void getClassicBooks(PageBean<ClassicBooks> classicBooksPageBean, String param) {
        if (param.equals(ClassicBooksConstant.CLASSICBOOKS_PARAM_SEARCH)) {
            classicBooksManager.getClassicBooksByPage(classicBooksPageBean);
            classicBooksManager.getTotalBooksCount(classicBooksPageBean);
        } else {
            classicBooksManager.getClassicBooksByPage(classicBooksPageBean, param);
            classicBooksManager.getTotalBooksCount(classicBooksPageBean, param);
        }
    }

    @Override
    public void getClassicBooksBySearchClassify(String searchBooks, PageBean<ClassicBooks> classicBooksPageBean, String meants) {
        if (ClassicBooksConstant.BooksSearchClassifyEnum.SEARCHBYTITLE.getValue().equals(meants)) {
            classicBooksManager.getClassicBooksLikeTitle(classicBooksPageBean, searchBooks);
            classicBooksManager.getClassicBooksCountLikeTitle(classicBooksPageBean, searchBooks);
        } else if (ClassicBooksConstant.BooksSearchClassifyEnum.SEARCHBYCREATOR.getValue().equals(meants)) {
            classicBooksManager.getClassicBooksLikeAuthor(classicBooksPageBean, searchBooks);
            classicBooksManager.getClassicBooksCountLikeAuthor(classicBooksPageBean, searchBooks);
        } else if (ClassicBooksConstant.BooksSearchClassifyEnum.SEARCHBYKEYWORD.getValue().equals(meants)) {
            classicBooksManager.getClassicBooksLikeKeyword(classicBooksPageBean, searchBooks);
            classicBooksManager.getClassicBooksCountLikeKeyword(classicBooksPageBean, searchBooks);
        }
    }

    @Override
    public List<String> checkBookClassifyIsExist(List<ClassicBooks> classicBooks) {
        List<String> strings = new ArrayList<>();
        Boolean exist;
        for (ClassicBooks classicBook : classicBooks) {
            if (StringUtils.isNotBlank(classicBook.getProcClassId())) {
                exist = bookClassificationService.checkIsBookClassifyIsExist(classicBook.getProcClassId());
                if (!exist) {
                    strings.add(classicBook.getProcEnbody());
                    continue;
                }
            }
        }
        return strings;
    }

    @Override
    public void getClassicBooksByDisplay(PageBean<ClassicBooks> classicBooksPageBean) {
        classicBooksManager.getClassicBooksByPageByDisplay(classicBooksPageBean);
        classicBooksManager.getTotalBooksCountByDisplay(classicBooksPageBean);
    }

    @Override
    public void updateClickCounts(String resourceId, Integer procQuote) {
        classicBooksManager.updateClickCounts(resourceId, procQuote);
    }

    @Override
    public void bookNameChooseBook(Map<String, String> pdfStringMap, List<ClassicBooks> classicBooks) {
        //这个地方增加一个调接口值
        String objectId = null;
        for (Map.Entry<String, String> ele : pdfStringMap.entrySet()) {
            if (StringUtils.isNotBlank(ele.getValue())) {
                try {
                    JSONObject jsonObject = new JSONObject(ele.getValue());
                    objectId = (String) jsonObject.get("objectId");
                    String result = HttpClientUtil.getRequest(EssayUploadConstant.DOCU_YUNPAN_URL + "&objectId=" + objectId);
                    pdfStringMap.put(ele.getKey(), result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String pdf = null;
        for (Map.Entry<String, String> ele : pdfStringMap.entrySet()) {
            for (ClassicBooks classicBook : classicBooks) {
                if (ele.getKey().contains(classicBook.getBasicTitle()) && null != ele.getValue() && !ele.getValue().contains("error")) {
                    try {
                        JSONObject jsonObject = new JSONObject(ele.getValue());
                        pdf = (String) jsonObject.get("pdf");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    classicBook.setProcFileLink(pdf);
                }
            }
        }
    }

    @Override
    public void setBookEnclosurePath(Map<String, String> pdfStringMap, List<ClassicBooks> classicBooks, String sign) {
        for (Map.Entry<String, String> ele : pdfStringMap.entrySet()) {
            for (ClassicBooks classicBook : classicBooks) {
                if (ele.getKey().contains(classicBook.getBasicTitle()) && null != ele.getValue()) {
                    if (sign.equals("1")) {
                        classicBook.setCnkiYycount(ele.getValue());
                    } else if (sign.equals("2")) {
                        classicBook.setWfYycount(ele.getValue());
                    } else if (sign.equals("3")){
                        classicBook.setCqvipYycount(ele.getValue());
                    }else {
                        classicBook.setScreenshot(ele.getValue());
                    }
                }
            }
        }
    }

    public PageBean getByNameAndClassification(PageBean<ClassicBooks> classicBooksPageBean, String book_name, int bookClassification) {
        return classicBooksManager.getByNameAndClassification(classicBooksPageBean, book_name, bookClassification);
    }

    @Override
    public List<ClassicBooks> getdisplayEsaayBook(String bookClassifyId, int book_classification) {
        return classicBooksManager.getdisplayEsaayBook(bookClassifyId, book_classification);
    }
}
