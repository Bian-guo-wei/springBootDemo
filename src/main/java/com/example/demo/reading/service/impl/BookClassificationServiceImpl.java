package com.example.demo.reading.service.impl;

//import com.example.demo.cit.admin.model.po.AdministratorPo;
//import com.example.demo.essay.constant.EssayInfoConstant;
import com.example.demo.essay.constant.EssayInfoConstant;
import com.example.demo.reading.constant.BookClassificationConstant;
import com.example.demo.reading.manager.BookClassificationManager;
import com.example.demo.reading.manager.ClassicBooksManager;
import com.example.demo.reading.model.bo.BookClassificationBo;
import com.example.demo.reading.model.bo.BookClassificationMapBo;
import com.example.demo.reading.model.po.BookClassificationPo;
import com.example.demo.reading.service.BookClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author admin
 */
@Service
public class BookClassificationServiceImpl implements BookClassificationService {
    @Autowired
    private BookClassificationManager bookClassificationManager;
    @Autowired
    private ClassicBooksManager classicBooksManager;

    @Override
    public List<BookClassificationPo> getAllClassificationInfos() {
        return bookClassificationManager.getAllClassificationInfosFromDataBase();
    }

    @Override
    public void initBookClassifyMap() {
        List<BookClassificationPo> allClassificationInfos = getAllClassificationInfos();
        try {
            for (BookClassificationPo bookClassificationPo : allClassificationInfos) {
                BookClassificationConstant.bookClassifyMap.put(bookClassificationPo.getClassificationId(), bookClassificationPo.getClassificationName());
                switch (bookClassificationPo.getClassificationRank()) {
                    case BookClassificationConstant.BOOK_CLASSIFY_RANK_FIRST:
                        BookClassificationConstant.firstBookClassifyMap.put(bookClassificationPo.getClassificationId(), bookClassificationPo);
                        break;
                    case BookClassificationConstant.BOOK_CLASSIFY_RANK_SECOND:
                        BookClassificationConstant.secondBookClassifyMap.put(bookClassificationPo.getParentClassificationId(), bookClassificationPo);
                        break;
                    case BookClassificationConstant.BOOK_CLASSIFY_RANK_THIRD:
                        BookClassificationConstant.thirdBookClassifyMap.put(bookClassificationPo.getParentClassificationId(), bookClassificationPo);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean addNewBookClassification(BookClassificationPo bookClassificationPo) {
        bookClassificationPo.setClassificationId(UUID.randomUUID().toString() + EssayInfoConstant.UUID_TIMESTAMP_SEPARATOR + System.currentTimeMillis());
        bookClassificationPo.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        return bookClassificationManager.addNewBookClassification(bookClassificationPo);
    }

    @Override
    public List<BookClassificationBo> handleBookClassification() {
        BookClassificationMapBo bookClassificationMapBo = trendGetBookClassificationMap();
        List<BookClassificationBo> bookClassificationBos = new ArrayList<>();
        BookClassificationBo bookClassificationBo;
        for (Map.Entry<String, BookClassificationPo> ele : bookClassificationMapBo.getFirstBookClassifyMap().entrySet()) {
            bookClassificationBo = new BookClassificationBo();
            bookClassificationBo.setOriginBookClassificationId(ele.getKey());
            bookClassificationBo.setFirstBookClassificationName(ele.getValue().getClassificationName());
            bookClassificationBo.setBookClassificationId(ele.getValue().getClassificationId());
            bookClassificationBo.setBookCounts(classicBooksManager.getTotalBooksCount(ele.getValue().getClassificationId()));
            bookClassificationBos.add(bookClassificationBo);
            for (Map.Entry<String, BookClassificationPo> el : bookClassificationMapBo.getSecondBookClassifyMap().entrySet()) {
                if (ele.getKey().equals(el.getValue().getParentClassificationId())) {
                    bookClassificationBo = new BookClassificationBo();
                    bookClassificationBo.setOriginBookClassificationId(ele.getKey());
                    bookClassificationBo.setParentBookClassificationId(el.getValue().getParentClassificationId());
                    bookClassificationBo.setBookClassificationId(el.getValue().getClassificationId());
                    bookClassificationBo.setSecondBookClassificationName(el.getValue().getClassificationName());
                    bookClassificationBo.setBookCounts(classicBooksManager.getTotalBooksCount(el.getValue().getClassificationId()));
                    bookClassificationBos.add(bookClassificationBo);
                    for (Map.Entry<String, BookClassificationPo> e : bookClassificationMapBo.getThirdBookClassifyMap().entrySet()) {
                        if (el.getValue().getClassificationId().equals(e.getValue().getParentClassificationId())) {
                            bookClassificationBo = new BookClassificationBo();
                            bookClassificationBo.setBookClassificationId(e.getValue().getClassificationId());
                            bookClassificationBo.setOriginBookClassificationId(ele.getKey());
                            bookClassificationBo.setThirdBookClassificationName(e.getValue().getClassificationName());
                            bookClassificationBo.setParentBookClassificationId(e.getValue().getParentClassificationId());
                            bookClassificationBo.setBookCounts(classicBooksManager.getTotalBooksCount(e.getValue().getClassificationId()));
                            bookClassificationBos.add(bookClassificationBo);
                        }
                    }
                }
            }
        }
        return bookClassificationBos;
    }

    @Override
    public BookClassificationMapBo trendGetBookClassificationMap() {
        List<BookClassificationPo> allClassificationInfos = getAllClassificationInfos();
        BookClassificationMapBo bookClassificationMapBo = new BookClassificationMapBo();
        for (BookClassificationPo bookClassificationPo : allClassificationInfos) {
            bookClassificationMapBo.getBookClassifyMap().put(bookClassificationPo.getClassificationId(), bookClassificationPo.getClassificationName());
            bookClassificationMapBo.getFirstBookClassifyMap().put(bookClassificationPo.getClassificationId(), bookClassificationPo);
            //            switch (bookClassificationPo.getClassificationRank()) {
//                case BookClassificationConstant.BOOK_CLASSIFY_RANK_FIRST:
//                    bookClassificationMapBo.getFirstBookClassifyMap().put(bookClassificationPo.getClassificationId(), bookClassificationPo);
//                    break;
//                case BookClassificationConstant.BOOK_CLASSIFY_RANK_SECOND:
//                    bookClassificationMapBo.getSecondBookClassifyMap().put(bookClassificationPo.getClassificationId(), bookClassificationPo);
//                    break;
//                case BookClassificationConstant.BOOK_CLASSIFY_RANK_THIRD:
//                    bookClassificationMapBo.getThirdBookClassifyMap().put(bookClassificationPo.getClassificationId(), bookClassificationPo);
//                    break;
//                default:
//                    break;
//            }
        }
        return bookClassificationMapBo;
    }

    @Override
    public Boolean modifyBookClassify(BookClassificationPo bookClassificationPo) {
        return bookClassificationManager.modifyBookClassification(bookClassificationPo);
    }

    @Override
    public Boolean delBookClassify(BookClassificationPo bookClassificationPo) {
        bookClassificationPo = bookClassificationManager.selectBookClassificationByClassificationId(bookClassificationPo.getClassificationId());
        switch (bookClassificationPo.getClassificationRank()) {
            case BookClassificationConstant.BOOK_CLASSIFY_RANK_FIRST:
                List<BookClassificationPo> bookClassificationPoList = bookClassificationManager.selectBookClassificationByParentClassificationId(bookClassificationPo.getClassificationId());
                for (BookClassificationPo bookClassification : bookClassificationPoList) {
                    bookClassificationManager.delBookClassificationByClassificationId(bookClassification.getClassificationId());
                    List<BookClassificationPo> bookClassificationPos = bookClassificationManager.selectBookClassificationByParentClassificationId(bookClassification.getClassificationId());
                    for (BookClassificationPo bookClassificationPo1 : bookClassificationPos) {
                        bookClassificationManager.delBookClassificationByClassificationId(bookClassificationPo1.getClassificationId());
                    }
                }
                break;
            case BookClassificationConstant.BOOK_CLASSIFY_RANK_SECOND:
                List<BookClassificationPo> bookClassificationPos = bookClassificationManager.selectBookClassificationByParentClassificationId(bookClassificationPo.getClassificationId());
                for (BookClassificationPo bookClassification : bookClassificationPos) {
                    bookClassificationManager.delBookClassificationByClassificationId(bookClassification.getClassificationId());
                }
                bookClassificationManager.delBookClassificationByClassificationId(bookClassificationPo.getClassificationId());
                break;
            case BookClassificationConstant.BOOK_CLASSIFY_RANK_THIRD:
                bookClassificationManager.delBookClassificationByClassificationId(bookClassificationPo.getClassificationId());
                break;
            default:
                break;
        }
        return bookClassificationManager.delBookClassificationByClassificationId(bookClassificationPo.getClassificationId());
    }

    @Override
    public Boolean topBookClassify(BookClassificationPo bookClassificationPo) {
        List<BookClassificationBo> bookClassificationBos = handleBookClassification();
        List<BookClassificationBo> bookClassificationBoList = new LinkedList<>(bookClassificationBos);
        BookClassificationBo bookClassification;
        for (BookClassificationBo bookClassificationBo : bookClassificationBoList) {
            if (bookClassificationBo.getBookClassificationId().equals(bookClassificationPo.getClassificationId())) {
                bookClassification = bookClassificationBo;
                break;
            }
        }
        switch (bookClassificationPo.getClassificationRank()) {
            case BookClassificationConstant.BOOK_CLASSIFY_RANK_FIRST:

                break;
            case BookClassificationConstant.BOOK_CLASSIFY_RANK_SECOND:

                break;
            case BookClassificationConstant.BOOK_CLASSIFY_RANK_THIRD:

                break;
            default:
                break;
        }
        return null;
    }

    @Override
    public Boolean checkIsBookClassifyIsExist(String procClassId) {
        return bookClassificationManager.checkIsBookClassifyIsExist(procClassId);
    }

    @Override
    public List<BookClassificationPo> getBookClassifyByParentId(Map<String, BookClassificationPo> bookClassificationMapBo, BookClassificationPo bookClassificationPo) {
        List<BookClassificationPo> bookClassificationPos = new ArrayList<>();
        if (null != bookClassificationMapBo) {
            for (Map.Entry<String, BookClassificationPo> ele : bookClassificationMapBo.entrySet()) {
                if (bookClassificationPo.getClassificationId().equals(ele.getValue().getParentClassificationId())) {
                    bookClassificationPos.add(ele.getValue());
                }
            }
        }
        return bookClassificationPos;
    }

}
