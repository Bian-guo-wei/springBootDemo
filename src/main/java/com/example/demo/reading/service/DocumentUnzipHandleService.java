package com.example.demo.reading.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface DocumentUnzipHandleService {

    /**
     * 解压文件夹
     *
     * @param file1
     * @return
     */
    List<MultipartFile> unzipDocument(HttpServletRequest request, MultipartFile file1);

    /**
     * 上传文件,云盘
     *
     * @param multipartFiles
     * @param url
     * @param paramMap
     * @return
     */
    Map<String, String> uploadWebService(List<MultipartFile> multipartFiles, String url, Map<String, String> paramMap);


    /**
     *  批量上传文件到服务器
     * @param multipartFiles
     * @param sign 标志，用来限定上传文件路径
     * @return
     */
    Map<String, String> uploadService(List<MultipartFile> multipartFiles, String sign, HttpServletRequest request);
}
