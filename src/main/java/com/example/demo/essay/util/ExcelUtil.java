package com.example.demo.essay.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author admin
 */
public class ExcelUtil {
    /**
     * 根据HSSFCell类型设置数据
     *
     * @param cell
     * @return
     */
    public static String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                // 如果当前Cell的Type为NUMERIC
                case NUMERIC:
                case FORMULA: {
                    // 判断当前的cell是否为Date
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        String val = String.valueOf(cell.getNumericCellValue());
                        BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
                        cellvalue = bd.toPlainString();
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = "";
            }
        }
        return cellvalue;
    }
}
