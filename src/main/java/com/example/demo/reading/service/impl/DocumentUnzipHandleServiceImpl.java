package com.example.demo.reading.service.impl;

import com.example.demo.reading.constant.EssayUploadConstant;
import com.example.demo.reading.service.DocumentUnzipHandleService;
import com.example.demo.reading.util.FileUtils;
import com.example.demo.reading.util.HttpClientUtil;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author admin
 */
@Service
public class DocumentUnzipHandleServiceImpl implements DocumentUnzipHandleService {
    @Override
    public List<MultipartFile> unzipDocument(HttpServletRequest request, MultipartFile file1) {
        List<MultipartFile> multipartFiles = new ArrayList<>();
        String fileName = file1.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        Map<String, String> map = new HashMap<>();
        File newFile = FileUtils.upLoadNewFile(request, map, file1, fileName, suffix);
        String filePath = map.get("filePath");

        try {
            ZipFile zipFile = new ZipFile(newFile, Charset.forName("GBK"));
            FileOutputStream outputStream;
            InputStream inputStream;
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            int length = 0;
            byte[] b = new byte[1024];
            while ((entries.hasMoreElements())) {
                ZipEntry zipEntry = entries.nextElement();
                String saveFilePaths = zipEntry.getName().replaceAll("\\\\", "/");
                String savepath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
                String lastFilePath = "";
//                if (saveFilePaths.indexOf("/") != -1) {
                    if (!zipEntry.isDirectory()) {
                        lastFilePath = savepath
                                + FileUtils.getRealFileName(savepath
                                + saveFilePaths.substring(0, saveFilePaths.indexOf(".")))
                                + saveFilePaths.substring(saveFilePaths.lastIndexOf("."));
                    }
                    if (!zipEntry.isDirectory()) {
                        File f = new File(lastFilePath);
                        // 如果当前解压缩文件的父级文件夹没有创建的话，则创建好父级文件夹
                        // 将当前文件的内容写入解压后的文件夹中。
//                        outputStream = new FileOutputStream(f);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        inputStream = zipFile.getInputStream(zipEntry);

                        while ((length = inputStream.read(b)) > 0) {
//                            outputStream.write(b, 0, length);
                            byteArrayOutputStream.write(b, 0, length);
                        }


                        byte[] byteFile = byteArrayOutputStream.toByteArray();
                        String suff = lastFilePath.substring(lastFilePath.lastIndexOf(".") + 1);
                        if (byteFile != null) {
                            File file = getFileFromBytes(byteFile, suff);
                            FileInputStream fileInputStream = new FileInputStream(file);
                            //注意这里面填啥，MultipartFile里面对应的参数就有啥，比如我只填了name，则
                            //MultipartFile.getName()只能拿到name参数，但是originalFilename是空。
                            MultipartFile multipartFile = new MockMultipartFile(zipEntry.getName(), fileInputStream);
                            multipartFiles.add(multipartFile);
                        }


                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return multipartFiles;
    }

    @Override
    public Map<String, String> uploadWebService(List<MultipartFile> multipartFiles, String url, Map<String, String> paramMap) {
        Map<String, String> map = new HashMap<>();
        String result;
        for (MultipartFile file : multipartFiles) {
            String fileName = file.getName();
            result = (String) HttpClientUtil.uploadDocu(file, EssayUploadConstant.DOCU_UPLOAD_YUNPAN_URL);
            map.put(fileName, result);
        }
        return map;
    }

    @Override
    public Map<String, String> uploadService(List<MultipartFile> multipartFiles , String sign, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        for (MultipartFile file : multipartFiles){
           String filePath = FileUtils.handleFileUpload(file, sign,request);
           map.put(file.getName(), filePath);
        }
        return map;
    }

    private File getFileFromBytes(byte[] byteFile, String suff) {
        BufferedOutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile("pattern", "." + suff);
            FileOutputStream fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(byteFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    private byte[] getImageFromNetByUrl(String strUrl) {
        try {
            // 通过输入流获取图片数据
            File file = new File(strUrl);
            InputStream inStream = new FileInputStream(file);
            // 得到图片的二进制数据
            byte[] btImg = readInputStream(inStream);
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private byte[] readInputStream(InputStream inStream) throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}
