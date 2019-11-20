package com.example.demo.reading.util;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class HttpUtil {
    protected static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    // Set the timeout in milliseconds until a connection is established.
    public static final int connectionTimeout = 30000;
    // Set the default socket timeout (SO_TIMEOUT) in milliseconds which is the timeout for waiting for data.
    public static final int soTimeout = 45000;
    public static final int soLinger = 60;

    /**
     * get方法获取远程网页信息
     *
     * @param url
     * @param contentEncode
     * @return
     */
    public static String getMethod(String url, String contentEncode) {
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, connectionTimeout);
        HttpConnectionParams.setSoTimeout(httpParameters, soTimeout);
        HttpConnectionParams.setLinger(httpParameters, soLinger);
        DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
        String html = "";
        try {
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpget);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                html = EntityUtils.toString(httpEntity, contentEncode);
                EntityUtils.consume(httpEntity);
            }
        } catch (ClientProtocolException e) {
            log.error(HttpUtil.class.getName() + " getMethod error:", e);
        } catch (IOException e) {
            log.error(HttpUtil.class.getName() + " getMethod error:", e);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return html;
    }

    /**
     * get方法获取远程网页信息，如果网页信息有编码信息按编码信息将返回的内容编码，如果没有则使用ISO-8859-1来进行编码
     *
     * @param url
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String getMethod(String url) throws ClientProtocolException, IOException {
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, connectionTimeout);
        HttpConnectionParams.setSoTimeout(httpParameters, soTimeout);
        HttpConnectionParams.setLinger(httpParameters, soLinger);
        DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
        String html = "";
        try {
            HttpGet httpGet = new HttpGet(url);
            BasicResponseHandler responseHandler = new BasicResponseHandler();
            html = httpClient.execute(httpGet, responseHandler);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return html;
    }

    public static String postMethod(String url, HttpEntity httpParameterEntity) throws Exception {
        return postMethod(url, httpParameterEntity, soTimeout);
    }

    /**
     * 使用post方法获取远程网页信息,支持301，302等跳转<br />
     * <p>
     * List<BasicNameValuePair> list=new ArrayList<BasicNameValuePair>(); <br />
     * list.add(new BasicNameValuePair("UserName","sxdxdx")); <br />
     * list.add(new BasicNameValuePair("PassWord","sxdxdx"));<br />
     * UrlEncodedFormEntity httpParameterEntity = new UrlEncodedFormEntity(list,"UTF-8");<br />
     * <p>
     * 如果网页信息有编码信息按编码信息将返回的内容编码，如果没有则使用ISO-8859-1来进行编码
     *
     * @param url
     * @param httpParameterEntity StringEntity,UrlEncodedFormEntity等类
     * @return
     */
    public static String postMethod(String url, HttpEntity httpParameterEntity, int soTimeout) throws Exception {
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, connectionTimeout);
        HttpConnectionParams.setSoTimeout(httpParameters, soTimeout);
        HttpConnectionParams.setLinger(httpParameters, soLinger);
        HttpProtocolParams.setUserAgent(httpParameters,
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0.1) Gecko/20100101 Firefox/5.0.1");
        DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
        String html = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            if (httpParameterEntity != null) {
                httpPost.setEntity(httpParameterEntity);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity httpEntity = httpResponse.getEntity();
                if (httpEntity != null) {
                    html = EntityUtils.toString(httpEntity);
                    EntityUtils.consume(httpEntity);
                }
                return html;
            }
            httpPost.abort();

            if (statusCode == HttpStatus.SC_MOVED_TEMPORARILY || statusCode == HttpStatus.SC_MOVED_PERMANENTLY
                    || statusCode == HttpStatus.SC_SEE_OTHER || statusCode == HttpStatus.SC_TEMPORARY_REDIRECT) {
                Header header = httpResponse.getFirstHeader("location");
                if (header == null) {
                    return html;
                }
                String newuri = header.getValue();
                if ((newuri == null) || (newuri.equals(""))) {
                    newuri = "/";
                }
                HttpGet httpGet = new HttpGet(newuri);
                httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                if (httpEntity != null) {
                    html = EntityUtils.toString(httpEntity);
                    EntityUtils.consume(httpEntity);
                }
                return html;
            }
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return html;
    }

    public static void download(String remoteFileUrl, String localFileName) {
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, connectionTimeout);
        HttpConnectionParams.setSoTimeout(httpParameters, soTimeout);
        HttpConnectionParams.setLinger(httpParameters, soLinger);
        DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
        HttpGet httpGet = new HttpGet(remoteFileUrl);

        OutputStream out = null;
        InputStream in = null;

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            in = entity.getContent();

            long length = entity.getContentLength();
            if (length <= 0) {
                System.out.println("下载文件不存在！");
                return;
            }

            File file = new File(localFileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            out = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int readLength = 0;
            while ((readLength = in.read(buffer)) > 0) {
                byte[] bytes = new byte[readLength];
                System.arraycopy(buffer, 0, bytes, 0, readLength);
                out.write(bytes);
            }

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将链接地址转换成相应的参数值
     *
     * @param url
     * @return
     */
    public static List<BasicNameValuePair> getParameterValue(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        String parm = url;
        if (parm.indexOf("?") != -1) {
            parm = parm.substring(parm.indexOf("?") + 1);
        }
        String[] kvs = parm.split("&");
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        for (String kv : kvs) {
            String[] s = StringUtils.split(kv, "=", 2);
            if (s.length == 2) {
                list.add(new BasicNameValuePair(s[0], s[1]));
            }
        }
        return list;
    }

    /**
     * 根据url链接地址串，得到相应参数值
     *
     * @param url
     * @param key
     * @return
     */
    public static String getParameterValue(String url, String key) {
        List<BasicNameValuePair> list = getParameterValue(url);
        for (BasicNameValuePair b : list) {
            if (b.getName().equals(key)) {
                return b.getValue();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        try {
            String url = "http://d0.ananas.chaoxing.com/download/afecaa926a4b96dcb15db4fcab1dc77f";
            HttpUtil.download(url, "E:/1.doc");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
