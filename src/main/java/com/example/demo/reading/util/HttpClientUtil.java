package com.example.demo.reading.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author admin
 */
public class HttpClientUtil {

    public static String postRequest(String url, Map<String, String> param) throws ClientProtocolException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();

//        String url = "http://test.kid.daya.chaoxing.com/toCloudDisk/getCloudDiskAnalysisByObjectId";

        HttpPost httpPost = new HttpPost(url);

        // 参数形式为key=value&key=value
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> ele : param.entrySet()) {
            formparams.add(new BasicNameValuePair(ele.getKey(), ele.getValue()));
        }


        // 加utf-8进行编码
        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httpPost.setEntity(uefEntity);

        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");

        return result;
    }


    public static String getRequest(String url) throws ClientProtocolException, IOException {
        // TODO Auto-generated constructor stub
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = httpclient.execute(httpget);

        String strResult = "";
        if (response != null) {
            HttpEntity entity = response.getEntity();
            strResult = EntityUtils.toString(entity, "UTF-8");
            System.out.println(strResult);
            EntityUtils.consume(entity);
        }
        httpget.abort();
        return strResult;
    }

    public static Object uploadDocu(MultipartFile file, String url) {
        // 第三方服务器请求地址
//            final String remote_url = "http://test.kid.daya.chaoxing.com/toCloudDisk/uploadImgByMultipartFile";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = null;
        try {
            String fileName = file.getName();
            HttpPost httpPost = new HttpPost(url);

            // 加utf-8进行编码
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            // 文件流
            builder.addBinaryBody("uploadFile", file.getInputStream(), ContentType.MULTIPART_FORM_DATA, fileName);
            // 类似浏览器表单提交，对应input的name和value
            builder.addTextBody("filename", fileName);
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            // 执行提交
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) throws ClientProtocolException, IOException {
        String url = "http://test.kid.daya.chaoxing.com/toCloudDisk/getCloudDiskAnalysisByObjectId";
        Map<String, String> map = new HashMap<String, String>();
        map.put("objectId", "a1abf9923846a462ac14afcb99b80cb4");
        String result = postRequest(url, map);
        System.out.println(result);
    }
}
