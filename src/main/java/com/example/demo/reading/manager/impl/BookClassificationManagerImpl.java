package com.example.demo.reading.manager.impl;

import com.example.demo.reading.manager.BookClassificationManager;
import com.example.demo.reading.mapper.BookClassificationPoMapper;
import com.example.demo.reading.model.po.BookClassificationPo;
import com.example.demo.reading.model.po.BookClassificationPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 */
@Service
public class BookClassificationManagerImpl implements BookClassificationManager {
    @Autowired
    private BookClassificationPoMapper bookClassificationPoMapper;

    @Override
    public List<BookClassificationPo> getAllClassificationInfosFromDataBase() {
        BookClassificationPoExample bookClassificationPoExample = new BookClassificationPoExample();
        bookClassificationPoExample.createCriteria();
        return bookClassificationPoMapper.selectByExample(bookClassificationPoExample);
    }

    @Override
    public Boolean addNewBookClassification(BookClassificationPo bookClassificationPo) {
        int count = bookClassificationPoMapper.insertSelective(bookClassificationPo);
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean modifyBookClassification(BookClassificationPo bookClassificationPo) {
        BookClassificationPoExample bookClassificationPoExample = new BookClassificationPoExample();
        bookClassificationPoExample.createCriteria().andClassificationIdEqualTo(bookClassificationPo.getClassificationId());
        int count = bookClassificationPoMapper.updateByExampleSelective(bookClassificationPo, bookClassificationPoExample);
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean delBookClassificationByClassificationId(String classificationId) {
        BookClassificationPoExample bookClassificationPoExample = new BookClassificationPoExample();
        bookClassificationPoExample.createCriteria().andClassificationIdEqualTo(classificationId);
        int count = bookClassificationPoMapper.deleteByExample(bookClassificationPoExample);
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public BookClassificationPo selectBookClassificationByClassificationId(String classificationId) {
        BookClassificationPoExample bookClassificationPoExample = new BookClassificationPoExample();
        bookClassificationPoExample.createCriteria().andClassificationIdEqualTo(classificationId);
        List<BookClassificationPo> bookClassificationPos = bookClassificationPoMapper.selectByExample(bookClassificationPoExample);
        return bookClassificationPos.get(0);
    }

    @Override
    public List<BookClassificationPo> selectBookClassificationByParentClassificationId(String parentClassificationId) {
        BookClassificationPoExample bookClassificationPoExample = new BookClassificationPoExample();
        bookClassificationPoExample.createCriteria().andParentClassificationIdEqualTo(parentClassificationId);
        return bookClassificationPoMapper.selectByExample(bookClassificationPoExample);
    }

    @Override
    public Boolean checkIsBookClassifyIsExist(String procClassId) {
        BookClassificationPoExample bookClassificationPoExample = new BookClassificationPoExample();
        bookClassificationPoExample.createCriteria().andClassificationIdEqualTo(procClassId);
        int count = bookClassificationPoMapper.countByExample(bookClassificationPoExample);
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String getClassfiyNameByClassfiyId(String classfiyId) {
        return bookClassificationPoMapper.getClassfiyNameByClassfiyId(classfiyId);
    }
}
