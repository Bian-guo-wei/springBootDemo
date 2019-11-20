package com.example.demo.reading.manager.impl;

import com.example.demo.reading.manager.BookEssayInfoMapperManager;
import com.example.demo.reading.mapper.BookssayInfoMapperPoMapper;
import com.example.demo.reading.model.po.BookssayInfoMapperPoExample;
import com.example.demo.reading.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/9/16.
 */
@Service
public class BookEssayInfoMapperManagerImpl implements BookEssayInfoMapperManager {

    @Autowired
    private BookssayInfoMapperPoMapper bookssayInfoMapperPoMapper;

    @Override
    public int deletByBookId(String bookId) {
        BookssayInfoMapperPoExample bookssayInfoMapperPoExample = new BookssayInfoMapperPoExample();
        bookssayInfoMapperPoExample.createCriteria().andResourceidEqualTo(bookId);
        int count = bookssayInfoMapperPoMapper.deleteByExample(bookssayInfoMapperPoExample);
        return count;
    }

    @Override
    public void insertByBookId(String bookId, String essayId) {
        List list = StringUtils.spliteByComma(essayId);
        for (int i = 0; i<list.size(); i++){
            bookssayInfoMapperPoMapper.insert(bookId, (String) list.get(i));
        }
    }

}
