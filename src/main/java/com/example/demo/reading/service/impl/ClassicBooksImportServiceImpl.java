package com.example.demo.reading.service.impl;

import com.example.demo.reading.model.bo.BookClassificationMapBo;
import com.example.demo.reading.model.po.BookClassificationPo;
import com.example.demo.reading.model.po.ClassicBooks;
import com.example.demo.reading.service.BookClassificationService;
import com.example.demo.reading.service.ClassicBooksImportService;
import com.example.demo.reading.util.ExcelUtil;
import com.example.demo.reading.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author admin
 */
@Service
public class ClassicBooksImportServiceImpl implements ClassicBooksImportService {
    private Pattern pattern = Pattern.compile("[A-Z]");
    @Autowired
    private BookClassificationService bookClassificationService;

    @Override
    public Boolean checkExcel(MultipartFile file) {
        if (file != null) {
            CommonsMultipartFile cf = (CommonsMultipartFile) file;
            if (cf.getFileItem().getName().contains("xls") || cf.getFileItem().getName().contains("xlxs")) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public List<ArrayList<String>> handleExcelData(MultipartFile file) {
        CommonsMultipartFile cf = (CommonsMultipartFile) file;
        List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        InputStream input = null;
        Workbook wb = null;
        ArrayList<String> rowList = null;
        try {
            input = file.getInputStream();
            if (cf.getFileItem().getName().contains("xls")) {
                wb = new HSSFWorkbook(input);
            } else {
                wb = new XSSFWorkbook(input);
            }
            //读取sheet
            Sheet sheetAt;
            Row row;
            int totalCells;
            Cell cell;
            for (int numSheet = 0; numSheet <= 0; numSheet++) {
                sheetAt = wb.getSheetAt(numSheet);
                if (sheetAt == null) {
                    continue;
                }
                //首行
                row = sheetAt.getRow(0);
                totalCells = row.getLastCellNum();
                for (int rowNum = 1; rowNum <= sheetAt.getLastRowNum(); rowNum++) {
                    row = sheetAt.getRow(rowNum);
                    if (null != row) {
                        rowList = new ArrayList<>();
                        for (int c = 0; c <= totalCells - 1; c++) {
                            cell = row.getCell(c);
                            if (null == cell) {
                                rowList.add(null);
                                continue;
                            }
                            rowList.add(ExcelUtil.getCellFormatValue(cell).trim());
                        }
                    }
                    list.add(rowList);
                }
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ClassicBooks> handleRowInfo2Po(List<ArrayList<String>> rowInfo) {
        List<ClassicBooks> classicBooks = new ArrayList<>();
        ClassicBooks classicBook;
        for (ArrayList<String> row : rowInfo) {
            classicBook = new ClassicBooks();
            for (int i = 0; i < row.size(); i++) {
                classicBook.setBasicTitle(row.get(0));
                if (StringUtils.isNotBlank(row.get(1))) {
                    //是否中图分类
                    Boolean cn = checkIsCNBookClassify(row.get(1));
                    classicBook.setProcClassId(changeProcEnbodyToProcClassid(cn, row.get(1)));
                }
                classicBook.setProcEnbody(row.get(1));
                classicBook.setBasicCreator(row.get(2));
                classicBook.setBasicPublisher(row.get(3));
                classicBook.setBasicDate(row.get(4));
                classicBook.setOriginalProjectResId(row.get(5));
                classicBook.setProcFileLink(row.get(6));
                if(row.get(7).equals("基本书目")){
                    classicBook.setBookClassification(2);
                }else if (row.get(7).equals("扩展书目")){
                    classicBook.setBookClassification(1);
                }else{
                    classicBook.setBookClassification(0);
                }
                classicBook.setDetaiurl(row.get(8));
                classicBook.setAvenue(row.get(9));
                classicBook.setWarePageView(row.get(10));
                classicBook.setBasicDescription(row.get(11));
                classicBook.setBasicSourceName(row.get(12));
                classicBook.setBasicPage(row.get(13));
                classicBook.setFoundation(row.get(14));
                classicBook.setViewElements(row.get(15));
                classicBook.setBasicKeyword(row.get(16));
                classicBook.setBasicContact(row.get(17));
            }
            classicBooks.add(classicBook);
        }
        return classicBooks;
    }




    private String changeProcEnbodyToProcClassid(Boolean cn, String s) {
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        BookClassificationPo bookClassificationPo = null;
        if (cn) {
            for (Map.Entry<String, String> ele : bookClassificationMapBo.getBookClassifyMap().entrySet()) {
                if (ele.getKey().contains(s.replaceAll("[^A-Z]", ""))) {
                    return ele.getKey();
                }
            }
        } else {
            for (Map.Entry<String, String> ele : bookClassificationMapBo.getBookClassifyMap().entrySet()) {
                if (ele.getValue().equals(s)) {
                    return ele.getKey();
                }
            }
            bookClassificationPo = new BookClassificationPo();
            bookClassificationPo.setClassificationName(s);
            bookClassificationService.addNewBookClassification(bookClassificationPo);
            this.changeProcEnbodyToProcClassid(cn,s);
        }
        return null;
    }

    @Override
    public Boolean checkIsCNBookClassify(String bookClassify) {
        Matcher matcher = pattern.matcher(bookClassify);
        return matcher.find();
    }
}
