package com.example.demo.reading.util;

import com.dayainfo.common.util.DigestUtils;
import com.dayainfo.common.util.EncodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


public class FileUtils extends org.apache.commons.io.FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    private static final URI WebRootPathURI = initWebRootPathURI();


    /**
     * 从云盘下载文件
     *
     * @param request
     * @param fileName
     * @param suffix
     * @return
     */
    public static File savePanFile(HttpServletRequest request, String remoteFileUrl, String fileName, String suffix, StringBuilder filePath) {
        // 保存普通文件
        String realName = getRealFileName(fileName.substring(0, fileName.indexOf("."))) + "." + suffix;
        String newFilePath = getNewFilePath(request);
        checkDirectory(newFilePath);// 检查文件所在的路径是不是存在，如果不存在则创建
        File newFile = null;
        String upLoadfilePath = newFilePath + realName;
        try {
            HttpUtil.download(remoteFileUrl, upLoadfilePath);
            filePath.append(upLoadfilePath);
        } catch (Exception e) {
            logger.error("FileUtils---->upLoadNewFile(single)", e);
        }
        return newFile;
    }

    /**
     * 单个文件上传
     *
     * @param request
     * @param file
     * @param fileName
     * @param suffix
     * @return
     */
    public static File upLoadNewFile(HttpServletRequest request, MultipartFile file, String fileName, String suffix,
                                     StringBuilder filePath) {
        // 保存普通文件
        String realName = getRealFileName(fileName.substring(0, fileName.lastIndexOf("."))) + "." + suffix;
        String newFilePath = getNewFilePath(request);
        checkDirectory(newFilePath);// 检查文件所在的路径是不是存在，如果不存在则创建
        File newFile = null;
        String upLoadfilePath = newFilePath + realName;
        try {
            newFile = new File(newFilePath, realName);
            FileCopyUtils.copy(file.getBytes(), newFile);
            filePath.append(upLoadfilePath);
        } catch (IOException e) {
            logger.error("FileUtils---->upLoadNewFile(single)", e);
        }
        return newFile;
    }

    /**
     * 批量上传保存压缩包文件
     *
     * @param request
     * @param file
     * @param fileName
     * @param suffix
     * @return
     */
    public static File upLoadNewFile(HttpServletRequest request, Map<String, String> map, MultipartFile file,
                                     String fileName, String suffix) {
        String realName = getRealFileName(fileName.substring(0, fileName.lastIndexOf("."))) + "." + suffix;
        String newFilePath = getNewFilePath(request);
        checkDirectory(newFilePath);
        File newFile = null;
        String upLoadfilePath = newFilePath + realName;
        try {
            newFile = new File(newFilePath, realName);
            FileCopyUtils.copy(file.getBytes(), newFile);
//			int length=2097152;
//			InputStream in= file.getInputStream();
//			FileOutputStream out=new FileOutputStream(newFile);
//			byte[] buffer=new byte[length];
//			while(true){
//				int ins=in.read(buffer);
//				if(ins==-1){
//					in.close();
//					out.flush();
//					out.close();
//					break;
//				}else{
//					out.write(buffer,0,ins);
//				}
//			}
        } catch (IOException e) {
            logger.error("FileUtils---->upLoadNewFile(multi)", e);
        }
        map.put("filePath", upLoadfilePath);
        return newFile;
    }

    /**
     * 远程保存自建库上传文献
     *
     * @param request
     * @param file
     * @param fileName
     * @param titleDesStr
     * @param suffix
     * @param filePath
     * @param timeStamp
     * @param taskId
     * @param userid
     * @return
     */
    public static File saveRemoteFile(HttpServletRequest request, MultipartFile file, String fileName,
                                      StringBuilder titleDesStr, String suffix, StringBuilder filePath, StringBuilder timeStamp, int userid,
                                      int taskId) throws Exception {
        // 保存普通文件
        String jmTit = getRealFileName(fileName.substring(0, fileName.indexOf(".")), timeStamp);
        String realName = jmTit + "." + suffix;
        String newFilePath = getSelfDBPath(request);
        String newDirectPath = String.format("%s/%s/%s", newFilePath, userid, taskId);// 组装文件路径
        checkDirectory(newDirectPath);// 检查文件所在的路径是不是存在，如果不存在则创建
        String realFilePath = newDirectPath + "/" + realName;
        File newFile = null;
        try {
            newFile = new File(realFilePath);
            FileCopyUtils.copy(file.getBytes(), newFile);
            filePath.append(realFilePath);
            titleDesStr.append(jmTit);
        } catch (IOException e) {
            logger.error("FileUtils---->saveRemoteFile()", e);
        }
        return newFile;
    }

    /**
     * 远程保存作业上传内容
     *
     * @param request
     * @param titleDesStr
     * @param suffix
     * @param filePath
     * @param timeStamp
     * @param taskId
     * @param userid
     * @return
     */
    public static boolean writeSelfTxtFile(HttpServletRequest request, String content,
                                           String titleDesStr, String suffix, StringBuilder filePath, StringBuilder timeStamp, int userid,
                                           int taskId) throws Exception {
        // 保存普通文件
        String jmTit = getRealFileName(titleDesStr, timeStamp);
        String realName = jmTit + "." + suffix;
        String newFilePath = getSelfDBPath(request);
        String newDirectPath = String.format("%s/%s/%s", newFilePath, userid + "_" + taskId, taskId);// 组装文件路径
        checkDirectory(newDirectPath);// 检查文件所在的路径是不是存在，如果不存在则创建
        String realFilePath = newDirectPath + "/" + realName;
        File newFile = null;
        try {
            newFile = new File(realFilePath);
            FileCopyUtils.copy(content.getBytes(), newFile);
            filePath.append(realFilePath);
            return true;
        } catch (IOException e) {
            logger.error("FileUtils---->saveRemoteFile()", e);
        }
        return false;
    }

    /**
     * 单个文件上传
     *
     * @param request
     * @param file
     * @param fileName
     * @param suffix
     * @return
     */
    public static File upLoadFilterNewFile(HttpServletRequest request, MultipartFile file, String fileName,
                                           String suffix, StringBuilder filePath) {
        // 保存普通文件
        String realName = getRealFileName(fileName.substring(0, fileName.indexOf("."))) + "." + suffix;
        String newFilePath = getFilterFilePath(request);
        checkDirectory(newFilePath);// 检查文件所在的路径是不是存在，如果不存在则创建
        File newFile = null;
        String upLoadfilePath = newFilePath + realName;
        try {
            newFile = new File(newFilePath, realName);
            FileCopyUtils.copy(file.getBytes(), newFile);
            filePath.append(upLoadfilePath);
        } catch (IOException e) {
            logger.error("FileUtils---->upLoadFilterNewFile(single)", e);
        }
        return newFile;
    }

    /**
     * 静态服务器中直接上传
     *
     * @param file
     * @return
     */
    public static String handleFileUpload(MultipartFile file, String sign , HttpServletRequest request) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        if(StringUtils.isBlank(fileName)){
            fileName = file.getName();
        }
        String filePath = PropertiesUtils.getUploadFilePath();
        if (StringUtils.isNotBlank(fileName)) {
            // 文件上传后的路径
            if (sign == "1") {
                fileName = "/pdf/"+fileName;
                filePath = filePath + fileName;
//                filePath = request.getServletContext().getRealPath("images/pdf");
            } else if (sign == "2") {
                fileName = "/material/"+fileName;
                filePath = filePath + fileName;
//                filePath = request.getServletContext().getRealPath("images/material");
            } else if (sign == "3"){
                fileName = "/courseware/"+fileName;
                filePath = filePath + fileName;

//                filePath = request.getServletContext().getRealPath("images/courseware");
            }else {

//                fileName = "/image/"+fileName;
//                filePath = filePath + fileName;
                filePath = request.getServletContext().getRealPath("images/uploadImg")+"/"+fileName;
            }
            File dest = new File(filePath);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                return fileName;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }


    public static void downLoad(HttpServletResponse response, String FileName){
        String path = PropertiesUtils.getUploadFilePath();
//        //通过文件路径获得File对象
        File file = new File(path + FileName);

        try {
            String downloadFileName = URLEncoder.encode(file.getName(),"UTF-8");
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();

            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());

            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Length", "" + file.length());
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 静态服务器中删除文件
     *
     * @param file
     * @return
     */
    public static Boolean handleFiledelete(MultipartFile file, HttpServletRequest request, String sign) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        String filePath = PropertiesUtils.getUploadFilePath();
        if (StringUtils.isNotBlank(fileName)) {
            // 文件上传的路径
            if (sign == "1") {
                filePath = filePath+"/pdf";
//                filePath = request.getServletContext().getRealPath("images/pdf");
            } else if (sign == "2") {
                filePath = filePath+"/material";
//                filePath = request.getServletContext().getRealPath("images/material");
            } else if (sign == "3"){
                filePath = filePath+"/courseware";
//                filePath = request.getServletContext().getRealPath("images/courseware");
            } else {
                filePath = filePath+"/image";
            }
            File dest = new File(filePath + "/" + fileName);
            try {
                Boolean result = dest.delete();
                return result;
            } catch (IllegalStateException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 将内容写入到文本文件
     *
     * @param request
     * @param fileName
     * @param content
     * @return
     */

    public static String writeTxtFile(HttpServletRequest request, String fileName, String content) {
        String filePath = getNewFilePath(request);
        String realName = getRealFileName(fileName) + ".txt";
        checkDirectory(filePath);// 检查文件所在的路径是不是存在，如果不存在则创建
        String upLoadfilePath = filePath + realName;
        File newFile = null;
        try {
            newFile = new File(filePath, realName);
            FileCopyUtils.copy(content.getBytes(), newFile);
        } catch (IOException e) {
            logger.error("FileUtils---->write2Txt()", e);
        }
        return upLoadfilePath;
    }

    /**
     * 初始化Web网站的根目录绝对路径
     *
     * @return
     */
    private static URI initWebRootPathURI() {
        try {
            return FileUtils.class.getResource("/").toURI().resolve("../../");
        } catch (URISyntaxException e) {
            logger.error("init WebRootPathURI", e);
            throw new IllegalStateException("FileUtils init WebRootPathURI error.", e);
        }
    }

    /**
     * 根据Web项目ROOT目录的相对路径，获取相应的文件
     *
     * @param relativePath
     * @return
     * @throws URISyntaxException
     */
    public static File toFileByWebProject(String relativePath) {
        return new File(WebRootPathURI.resolve(StringUtils.removeStart(relativePath, "/")));
    }

    /**
     * 获取Web网站的根目录绝对路径
     *
     * @return
     */
    public static URI getWebRootPathURI() {
        return WebRootPathURI;
    }

    /**
     * 获取Web网站的根目录绝对路径
     *
     * @return
     */
    public static String getWebRootPath() {
        return EncodeUtils.urlDecode(WebRootPathURI.getPath());
    }

    /**
     * 获取保存的真实文件名
     *
     * @return
     */
    public static String getRealFileName(String fileName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(DigestUtils.md5ToHex(fileName + DateFormatUtils.curDateTime("yyyyMMddHHmmss")
                + "vbfjhd"));
        return buffer.toString();
    }

    /**
     * 获取保存的真实文件名
     *
     * @return
     */
    public static String getRealFileName(String fileName, StringBuilder timeStamp) throws Exception {
        String tmStamp = DateFormatUtils.curDateTime("yyyyMMddHHmmss");
        timeStamp.append(tmStamp);
        StringBuffer buffer = new StringBuffer();
        buffer.append(DigestUtils.md5ToHex(fileName + tmStamp + "vbfjhd"));
        return buffer.toString();
    }

    /**
     * 获取文件存放的绝对路径
     *
     * @param request
     * @return
     */
    private static String getRealPath(HttpServletRequest request) {
        String rootPath = PropertiesUtils.getUploadFilePath();
        if (StringUtils.isBlank(rootPath)) {
            rootPath = request.getServletContext().getRealPath("");
        }
        return rootPath;
    }

    /**
     * 获取文件存放的绝对路径
     *
     * @param request
     * @return
     */
    private static String getSelfDBPath(HttpServletRequest request) {
        String rootPath = PropertiesUtils.getSelfDBFilePath();
        if (StringUtils.isBlank(rootPath)) {
            rootPath = request.getServletContext().getRealPath("");
        }
        return rootPath;
    }

    /**
     * 生成要上传的日期路径
     *
     * @return
     */
    private static String createDatePath() {
        Date myDate = new Date();
        Calendar calendar = DateUtils.toCalendar(myDate);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String monthStr = "";
        String dayStr = "";
        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = NumberUtils.toString(month);
        }
        if (day < 10) {
            dayStr = "0" + day;
        } else {
            dayStr = NumberUtils.toString(day);
        }
        return String.format("%s/%s/%s/", calendar.get(Calendar.YEAR), monthStr + dayStr,
                calendar.get(Calendar.HOUR_OF_DAY));
    }

    /**
     * 验证文件路径是否存在，如果不存在，则创建
     *
     * @param newFilePath
     */
    public static void checkDirectory(String newFilePath) {
        File f = new File(newFilePath);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    /**
     * 获得上传文件路径
     *
     * @param request
     * @return
     */
    public static String getNewFilePath(HttpServletRequest request) {
        String filePath = getRealPath(request);
        String datePath = createDatePath();// 生成日期路径
        String newFilePath = String.format("%s/%s", filePath, datePath);// 组装文件路径
        return newFilePath;
    }

    /**
     * 获得上传文件路径
     *
     * @param request
     * @return
     */
    public static String getFilterFilePath(HttpServletRequest request) {
        String filePath = getRealPath(request);
        String datePath = createDatePath();// 生成日期路径
        String newFilePath = String.format("%s/%s/%s", filePath, "excel", datePath);// 组装文件路径
        return newFilePath;
    }

}
