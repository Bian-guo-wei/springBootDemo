package com.example.demo.essay.service.impl;

import com.dayainfo.common.util.Base64Util;
import com.dayainfo.common.util.StringUtils;
import com.example.demo.essay.constant.ExcelConstant;
import com.example.demo.essay.manager.EssayAwardManager;
import com.example.demo.essay.manager.EssayInfoManager;
import com.example.demo.essay.model.bo.ExcelImportResultBo;
import com.example.demo.essay.model.po.EssayAwardPo;
import com.example.demo.essay.model.po.EssayInfoPo;
import com.example.demo.essay.service.EssayWinnerService;
import com.example.demo.essay.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EssayWinnerServiceImpl implements EssayWinnerService {
    private static final Logger logger = LoggerFactory.getLogger(EssayWinnerServiceImpl.class);
    @Autowired
    EssayAwardManager essayAwardManager;
    @Autowired
    EssayInfoManager essayInfoManager;
    @Override
    public void resultSetToExcel(HttpServletResponse response, String sheetName, List<EssayAwardPo> result) {
        OutputStream toClient = null;
        try {
            Date date = new Date();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet();
            workbook.setSheetName(0, sheetName);

            HSSFCell cell;
            List<String> itemList = new ArrayList<String>();
            itemList.add(ExcelConstant.NUMBER);
            itemList.add(ExcelConstant.ESSAY_NAME);
            itemList.add(ExcelConstant.ESSAY_WINNER_NAME);
            itemList.add(ExcelConstant.ESSAY_ARTICLE_NAME);
            itemList.add(ExcelConstant.AWARD_NAME);

            HSSFRow row = sheet.createRow(0);
            // 写入各个字段的名称
            cell = row.createCell(0);
            HSSFCellStyle setBorder = workbook.createCellStyle();
            HSSFFont font = workbook.createFont();
            font.setFontName("黑体");
            font.setBold(true);
            font.setFontHeightInPoints((short) 20);
            setBorder.setFont(font);
            setBorder.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(setBorder);
            cell.setCellValue(sheetName);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, itemList.size() - 1));
            //第二行
            row = sheet.createRow(1);
            cell = row.createCell(0);
            font.setFontName("黑体");
            font.setBold(true);
            font.setFontHeightInPoints((short) 19);// 设置字体大小
            setBorder.setFont(font);
            cell.setCellStyle(setBorder);
            cell.setCellValue(new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date()));
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, itemList.size() - 1));
            //第三行,就是字段名
            row = sheet.createRow(2);
            int cellFlag = 0;
            for (int i = 0; i < itemList.size(); i++) {
                setBorder = workbook.createCellStyle();
                font = workbook.createFont();
                font.setFontName("黑体");
                font.setBold(true);
                font.setFontHeightInPoints((short) 12);
                setBorder.setFont(font);
                setBorder.setAlignment(HorizontalAlignment.CENTER);
                setBorder.setVerticalAlignment(VerticalAlignment.CENTER);

                if (cellFlag == 0) {
                    sheet.setColumnWidth(0, 2000);
                } else if (itemList.get(i).equals(ExcelConstant.NUMBER)) {
                    sheet.setColumnWidth(cellFlag, 2000);
                } else if (itemList.get(i).equals(ExcelConstant.ESSAY_NAME) || itemList.get(i).equals(ExcelConstant.SCHOOL)
                        || itemList.get(i).equals(ExcelConstant.ESSAY_WINNER_NAME) || itemList.get(i).equals(ExcelConstant.DEPARTMENT)
                        || itemList.get(i).equals(ExcelConstant.STUDENT_CODE) || itemList.get(i).equals(ExcelConstant.AWARD_NAME)
                        || itemList.get(i).equals(ExcelConstant.ESSAY_ARTICLE_NAME)) {
                    sheet.setColumnWidth(cellFlag, 5000);
                }
                cell = row.createCell(i);
                cell.setCellValue(itemList.get(i));
//
                cell.setCellStyle(setBorder);
                cellFlag++;
            }
            setBorder = workbook.createCellStyle();
            font = workbook.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 12);
            setBorder.setFont(font);
            setBorder.setAlignment(HorizontalAlignment.LEFT);
            int iRow = 3;
            int k = 1;
            // 写入各条记录，每条记录对应Excel中的一行
            for (int i = 0; i < result.size(); i++) {
                row = sheet.createRow(iRow);
                EssayAwardPo po = result.get(i);
                int flag = 0;

                cell = row.createCell(flag++);
                cell.setCellStyle(setBorder);
                cell.setCellValue(k);

                cell = row.createCell(flag++);
                cell.setCellStyle(setBorder);
                cell.setCellValue(StringUtils.isNotBlank(po.getEssayName()) ? po.getEssayName() : "");

                cell = row.createCell(flag++);
                cell.setCellStyle(setBorder);
                cell.setCellValue(StringUtils.isNotBlank(po.getCompetitorName()) ? po.getCompetitorName() : "");

                cell = row.createCell(flag++);
                cell.setCellStyle(setBorder);
                cell.setCellValue(StringUtils.isNotBlank(po.getArticleTitle()) ? po.getArticleTitle() : "");

                cell = row.createCell(flag++);
                cell.setCellStyle(setBorder);
                cell.setCellValue(po.getAwardName());

                iRow++;
                k++;
            }
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode("获奖名单导出--"+System.currentTimeMillis()+".xls", "UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            toClient = new BufferedOutputStream(response.getOutputStream());
            workbook.write(toClient);
            toClient.flush();
        } catch (Exception e) {
            logger.error("EssayWinnerServiceImpl-->resultSetToExcel excel error", e);
        } finally {
            try {
                if (toClient != null) {
                    toClient.close();
                }
            } catch (Exception e) {
                logger.error("EssayWinnerServiceImpl-->resultSetToExcel close BufferedOutputStream error", e);
                toClient = null;
            }
        }
    }

    @Override
    public ExcelImportResultBo insertWinnerFromExcel(MultipartFile file, String essayId, int adminId, int type) {
        EssayInfoPo essayInfoPo = essayInfoManager.selectOneEssayinfoByUuid(essayId);
        ExcelImportResultBo excelImportResultBo = new ExcelImportResultBo();
        excelImportResultBo.setResult(false);
        List<String> errorUname = new ArrayList<>();
        Boolean result = Boolean.FALSE;
        File newFile = null;
        try {
            //TODO:服务器路径
            newFile = new File(Base64Util.readProperties("/config/excel.properties", "GENERATED_EXCEL_PATH"), file.getOriginalFilename());
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            FileCopyUtils.copy(file.getBytes(), newFile);
        } catch (IOException e) {
            logger.error("EssayWinnerServiceImpl---->insertClassListFromExcel", e);
            return excelImportResultBo;
        }
        File files = newFile;
        if (!files.exists()) {
            logger.error("EssayWinnerServiceImpl---->excel写入失败");
            return excelImportResultBo;
        } else {
            try {
                List<EssayAwardPo> list = new ArrayList<>();
                FileInputStream is = new FileInputStream(files);
                POIFSFileSystem fs = new POIFSFileSystem(is);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                // 得到总行数
                int rowNum = sheet.getLastRowNum();
                HSSFRow row = sheet.getRow(0);
                EssayAwardPo po;
                    for (int i = 2; i <= rowNum; i++) {
                        row = sheet.getRow(i);
                        if (row != null) {
                            po = new EssayAwardPo();
                            po.setCompetitorName(ExcelUtil.getCellFormatValue(row.getCell(1)).trim());
                            po.setArticleTitle(ExcelUtil.getCellFormatValue(row.getCell(2)).trim());
                            po.setAwardName(ExcelUtil.getCellFormatValue(row.getCell(3)).trim());
                            po.setEssayName(essayInfoPo.getTitle());
                            po.setEssayId(essayId);
                            po.setAdminId(adminId);
                            if (essayAwardManager.order(po)) {
                                excelImportResultBo.setResult(true);
                            }
                        }
                    }
            } catch (Exception e) {
                logger.error("EXCEL转换为获奖名单信息失败", e);
                return excelImportResultBo;
            } finally {
                files.delete();
            }
        }
        excelImportResultBo.setErrorUname(errorUname);
        return excelImportResultBo;
    }
}
