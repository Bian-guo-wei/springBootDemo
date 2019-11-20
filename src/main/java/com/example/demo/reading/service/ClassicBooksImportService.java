package com.example.demo.reading.service;

import com.example.demo.reading.model.po.ClassicBooks;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
public interface ClassicBooksImportService {
    /**
     * 检查文件是否为Excel文件
     *
     * @param file
     * @return
     */
    Boolean checkExcel(MultipartFile file);

    /**
     * 处理excel数据
     *
     * @param file
     * @return
     */
    List<ArrayList<String>> handleExcelData(MultipartFile file);

    /**
     * 把行信息转换成相应的图书po类
     *
     * @param rowInfo
     * @return
     */
    List<ClassicBooks> handleRowInfo2Po(List<ArrayList<String>> rowInfo);

    /**
     * 检测是否是中图分类
     *
     * @param bookClassify
     * @return
     */
    Boolean checkIsCNBookClassify(String bookClassify);

}
