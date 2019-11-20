package com.example.demo.website.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

/**
 * 处理非法字符
 *
 * @author Administrator
 */
public class XssShieldUtil {
    private static List<Pattern> patterns = null;

    public static String escapeFilter(String value) {
        StringBuffer result = new StringBuffer();
        if (value == null) {
            return null;
        } else {
            char content[] = new char[value.length()];
            value.getChars(0, value.length(), content, 0);
            result = new StringBuffer(content.length + 50);
            for (int i = 0; i < content.length; i++)
                switch (content[i]) {
                    case 34: // '"'
                        result.append("&quot;");
                        break;
                    case 38: // '&'
                        result.append("&amp;");
                        break;
                    case 39: // '\''
                        result.append("&#39;");
                        break;
                    case 60: // '<'
                        result.append("&lt;");
                        break;
                    case 62: // '>'
                        result.append("&gt;");
                        break;
                    default:
                        result.append(content[i]);
                        break;
                }
        }
        return result.toString();
    }

    private static List<Object[]> getXssPatternList() {
        List<Object[]> ret = new ArrayList<Object[]>();
        ret.add(new Object[]{"<(no)?script[^>]*>.*?</(no)?script>", Pattern.CASE_INSENSITIVE});
        ret.add(new Object[]{"eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"(javascript:|vbscript:|view-source:)*", Pattern.CASE_INSENSITIVE});
        ret.add(new Object[]{"<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{
                "<+\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror=|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+\\s*=+",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"&.*?|$.*?|CR.*?|LF.*?|\\.*?", Pattern.CASE_INSENSITIVE});
        ret.add(new Object[]{"%22", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"%27", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"%3E", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"%3e", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"%3C", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"%3c", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"<", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{">", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"\\+", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"\\(", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{" and ", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{" or ", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{" 1=1 ", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        return ret;
    }

    private static List<Pattern> getPatterns() {
        if (patterns == null) {
            List<Pattern> list = new ArrayList<Pattern>();
            String regex = null;
            Integer flag = null;
            int arrLength = 0;
            for (Object[] arr : getXssPatternList()) {
                arrLength = arr.length;
                for (int i = 0; i < arrLength; i++) {
                    regex = (String) arr[0];
                    flag = (Integer) arr[1];
                    list.add(Pattern.compile(regex, flag));
                }
            }
            patterns = list;
        }
        return patterns;
    }

    public static String stripXss(String value) {
        if (StringUtils.isNotBlank(value)) {
            Matcher matcher = null;
            for (Pattern pattern : getPatterns()) {
                matcher = pattern.matcher(value);
                // 匹配
                if (matcher.find()) {
                    // 删除相关字符串
                    value = matcher.replaceAll("");
                }
            }
            value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;").trim();
        }
        // if (LOG.isDebugEnabled())
        // LOG.debug("strip value: " + value);
        return value;
    }



    public static void main(String[] args) {
        String value = null;
        value = XssShieldUtil.stripXss("<script language=text/javascript>alert(document.cookie);</script>");
        value = XssShieldUtil.stripXss("<script src='' onerror='alert(document.cookie)'></script>");
        value = XssShieldUtil.stripXss("</script>");
        value = XssShieldUtil.stripXss(" eval(abc);");
        value = XssShieldUtil.stripXss(" expression(abc);");
        value = XssShieldUtil.stripXss("<img src='' onerror='alert(document.cookie);'></img>");
        value = XssShieldUtil.stripXss("<img src='' onerror='alert(document.cookie);'/>");
        value = XssShieldUtil.stripXss("<img src='' onerror='alert(document.cookie);'>");
        value = XssShieldUtil.stripXss("<script language=text/javascript>alert(document.cookie);");
        value = XssShieldUtil.stripXss("<script>window.location='url'");
        value = XssShieldUtil.stripXss(" onload='alert(\"abc\");");
        value = XssShieldUtil.stripXss("<img src=x<!--'<\"-->>");
        value = XssShieldUtil.stripXss("<=img onstop=");
        value = XssShieldUtil.stripXss("%233E|dd&22");
    }
}
