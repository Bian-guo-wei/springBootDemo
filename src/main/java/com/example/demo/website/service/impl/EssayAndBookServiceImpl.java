package com.example.demo.website.service.impl;

import com.dayainfo.common.util.EncodeUtils;
import com.dayainfo.common.util.JsonMapper;
import com.example.demo.essay.mapper.EssayInfoHistoryPoMapper;
import com.example.demo.essay.model.po.EssayInfoHistoryPo;
import com.example.demo.website.service.EssayAndBookService;
import com.example.demo.reading.constant.ClassicBooksConstant;
import com.example.demo.reading.mapper.BookClassificationPoMapper;
import com.example.demo.reading.mapper.ClassicBooksMapper;
import com.example.demo.reading.model.po.ClassicBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2019/10/11.
 */
@Service
public class EssayAndBookServiceImpl implements EssayAndBookService {

    @Autowired
    private EssayInfoHistoryPoMapper essayInfoHistoryPoMapper;
    @Autowired
    private ClassicBooksMapper classicBooksMapper;
    @Autowired
    private BookClassificationPoMapper bookClassificationPoMapper;

    @Override
    public int insertEssayHistory(String essayInfoHistoryPoStr) {

        essayInfoHistoryPoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(essayInfoHistoryPoStr));
        EssayInfoHistoryPo essayInfoHistoryPo = new JsonMapper().fromJson(essayInfoHistoryPoStr, EssayInfoHistoryPo.class);
        Long time = System.currentTimeMillis();
        essayInfoHistoryPo.setGmtCreate(new Timestamp(time));
        essayInfoHistoryPo.setStatus(0);

        List<ClassicBooks> classicBooksList = classicBooksMapper.selectByUuid(essayInfoHistoryPo.getUuid());

        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer basicBooks = new StringBuffer();
        StringBuffer expandBooks = new StringBuffer();
        if (classicBooksList.size()>0){
            for (ClassicBooks classicBooks : classicBooksList) {
                String classifyName = bookClassificationPoMapper.getClassfiyNameByClassfiyId(classicBooks.getProcClassId());
                //基本书目
                if (classicBooks.getBookClassification() == 2){
                    basicBooks.append("<tr>");
                    basicBooks.append(" <td style=\"width:189px;\">\n" +
                            "            <p align=\"justify\">" + classifyName + "</p>\n" +
                            "        </td>");
                    basicBooks.append(" <td style=\"width:189px;\">\n" +
                            "            <p align=\"justify\">" + classicBooks.getBasicTitle() + "</p>\n" +
                            "        </td>");
                    basicBooks.append(" <td style=\"width:189px;\">\n" +
                            "            <p align=\"justify\">" + classicBooks.getBasicCreator() + "</p>\n" +
                            "        </td>");
                    basicBooks.append("</tr>");

                }else if (classicBooks.getBookClassification() == 1){              //扩展书目

                    expandBooks.append("<tr>");
                    expandBooks.append(" <td style=\"width:189px;\">\n" +
                            "            <p align=\"justify\">" + classifyName + "</p>\n" +
                            "        </td>");
                    expandBooks.append(" <td style=\"width:189px;\">\n" +
                            "            <p align=\"justify\">" + classicBooks.getBasicTitle() + "</p>\n" +
                            "        </td>");
                    expandBooks.append(" <td style=\"width:189px;\">\n" +
                            "            <p align=\"justify\">" + classicBooks.getBasicCreator() + "</p>\n" +
                            "        </td>");
                    expandBooks.append("</tr>");
                }
            }
        }

        stringBuffer.append("<p align=\"justify\">" + essayInfoHistoryPo.getTitle() + "</p>");
        stringBuffer.append("<p align=\"justify\">活动说明：" + essayInfoHistoryPo.getClaim() + "</p><p align=\"justify\">\n" +
                "    &nbsp;</p>");
        stringBuffer.append("<p align=\"justify\">\n" +
                "    此次活动书目如下：</p>\n" +
                "<p align=\"justify\">\n" +
                "    （1）基本书目</p>\n" +
                "<table border=\"1\" cellspacing=\"0\" style=\"width:568px;\">\n" +
                "    <tbody>");
        stringBuffer.append("<tr>\n" +
                "        <td style=\"width:189px;\">\n" +
                "            <p align=\"justify\">\n" +
                "                学科领域</p>\n" +
                "        </td>\n" +
                "        <td style=\"width:189px;\">\n" +
                "            <p align=\"justify\">\n" +
                "                书名</p>\n" +
                "        </td>\n" +
                "        <td style=\"width:189px;\">\n" +
                "            <p align=\"justify\">\n" +
                "                作者</p>\n" +
                "        </td>\n" +
                "    </tr>");

        stringBuffer.append(basicBooks);
        stringBuffer.append("    </tbody>\n" +
                "</table>");

        stringBuffer.append("<p align=\"justify\">\n" +
                "    &nbsp;</p>\n" +
                "<p align=\"justify\">\n" +
                "    （2）扩展书目</p>\n" +
                "<table border=\"1\" cellspacing=\"0\" style=\"width:568px;\">\n" +
                "    <tbody>");

        stringBuffer.append("<tr>\n" +
                "        <td style=\"width:189px;\">\n" +
                "            <p align=\"justify\">\n" +
                "                学科领域</p>\n" +
                "        </td>\n" +
                "        <td style=\"width:189px;\">\n" +
                "            <p align=\"justify\">\n" +
                "                书名</p>\n" +
                "        </td>\n" +
                "        <td style=\"width:189px;\">\n" +
                "            <p align=\"justify\">\n" +
                "                作者</p>\n" +
                "        </td>\n" +
                "    </tr>");
        stringBuffer.append(expandBooks);
        stringBuffer.append(" </tbody>\n" +
                "</table>\n" +
                "<p>\n" +
                "    &nbsp;</p>");

        essayInfoHistoryPo.setDetail(String.valueOf(stringBuffer));
        essayInfoHistoryPo.setUuid(UUID.randomUUID() + ClassicBooksConstant.UUID_TIMESTAMP_SEPARATOR + System.currentTimeMillis());
        int count = essayInfoHistoryPoMapper.insert(essayInfoHistoryPo);

        return count;
    }
}
