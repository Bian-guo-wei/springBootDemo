package com.example.demo.reading.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static float strToFloat(String str) {
        if (str == null)
            return 0.0f;
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    /**
     * 截取部分字符串，这里一个汉字的长度认为是2
     *
     * @param str
     * @param len
     * @return
     */
    public static String getPartString(String str, int len) {
        try {
            byte b[];
            int counterOfDoubleByte = 0;
            b = str.getBytes("GBK");
            if (b.length <= len) {
                return str;
            }
            for (int i = 0; i < len; i++) {
                if (b[i] < 0) {
                    counterOfDoubleByte++;
                }
            }
            if (counterOfDoubleByte % 2 == 0) {
                return new String(b, 0, len, "GBK") + "...";
            } else {
                return new String(b, 0, len - 1, "GBK") + "...";
            }
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 取到简单的xml节点下的值；如<uid>用户名</uid><pswd>密码</pswd><gid>账号所属单位id</gid> 取到“密码”节点的值getSimpleXMLValue("<uid>用户名</uid><pswd>密码</pswd><gid>账号所属单位id</gid>","pswd")
     *
     * @param simpleXml
     * @param nodeName
     * @return 没有找到返回空
     */
    public static String getSimpleXMLValue(String simpleXml, String nodeName) {
        String value = "";
        try {
            String s = "<" + nodeName + ">";
            String e = "</" + nodeName + ">";
            value = simpleXml.substring((simpleXml.indexOf(s) + s.length()), (simpleXml.indexOf(e)));
        } catch (Exception e) {
        }
        return value;
    }

    /**
     * 替换特殊字符
     *
     * @param param
     * @return
     */
    public static String filterSpecificChar(String param) {
        param = param.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("/", "").replaceAll("&", "");
        return param;
    }

    //截取课程链接中的课程id
    public static String matchResult(String str) {
        if (str.isEmpty() || str.length() < 35) {
            return null;
        }
        ;
        str = str.substring(34);
        String regEx = "[0-9]";
        Pattern p = Pattern.compile(regEx);
        StringBuilder sb = new StringBuilder();
        Matcher m = p.matcher(str);
        while (m.find())
            for (int i = 0; i <= m.groupCount(); i++) {
                sb.append(m.group());
            }
        return sb.toString();
    }

    public static List spliteByComma(String s){
        String a[] = s.split(",");
        ArrayList list = new ArrayList();
        for (int i = 0; i<a.length; i++){
            list.add(a[i]);
        }
        return list;
    }

}
