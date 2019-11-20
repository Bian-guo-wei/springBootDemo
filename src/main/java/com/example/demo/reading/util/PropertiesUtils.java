package com.example.demo.reading.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author simone (wangxinsh55@126.com)
 */
public class PropertiesUtils {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    private final static Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(PropertiesUtils.class.getResource(
                    "/config/config.properties").toURI()));
            InputStreamReader inputStrReader = new InputStreamReader(fileInputStream, "UTF-8");
            properties.load(inputStrReader);
            inputStrReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            logger.error("PropertiesUtils init error", e);
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 根据属性名获取其int值
     *
     * @param name
     * @param defaultValue
     * @return
     */
    private static int getProperty(String name, int defaultValue) {
        String value = properties.getProperty(name);
        return value == null ? defaultValue : Integer.parseInt(value);
    }

    /**
     * 根据属性名获取其int值
     *
     * @param name
     * @param defaultValue
     * @return
     */
    private static long getProperty(String name, long defaultValue) {
        String value = properties.getProperty(name);
        return value == null ? defaultValue : Long.parseLong(value);
    }

    /**
     * 根据属性名获取其boolean值
     *
     * @param name
     * @param defaultValue
     * @return
     */
    private static boolean getProperty(String name, boolean defaultValue) {
        String value = properties.getProperty(name);
        return value == null ? defaultValue : Boolean.parseBoolean(value);
    }

    /**
     * 获取客户端RMI的端口
     *
     * @return
     */
    public static int getRMIClientPort() {
        return getProperty("rmi.client.port", 6000);
    }

    /**
     * 获取客户端RMI服务名
     *
     * @return
     */
    public static String getRMIClientServiceName() {
        return properties.getProperty("rmi.client.serviceName");
    }

    /**
     * 抛弃客户端的超时时间
     *
     * @return
     */
    public static long getDropTimeoutClientTime() {
        return getProperty("rmi.drop.timeout.client.time", 60000);
    }

    /**
     * 获取上传文件的保存路径
     *
     * @return
     */
    public static String getUploadFilePath() {
        return properties.getProperty("fileCache");
    }

    /**
     * 获取上传文件的保存路径
     *
     * @return
     */
    public static String getSelfDBFilePath() {
        return properties.getProperty("dayaFileStore");
    }

    /**
     * 另一台服务器的请求地址
     *
     * @return
     */
    public static String getOtherClientUrl() {
        return properties.getProperty("otherClientUrl");
    }
}
