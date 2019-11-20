package com.example.demo.reading.manager;

/**
 * Created by admin on 2019/9/16.
 */
public interface BookEssayInfoMapperManager {
    int deletByBookId(String bookId);

    void insertByBookId(String bookId, String essayId);
}
