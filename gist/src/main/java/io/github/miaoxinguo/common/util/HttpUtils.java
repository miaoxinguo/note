package io.github.miaoxinguo.common.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;

@SuppressWarnings(value = {"unused", "WeakerAccess"})
public final class HttpUtils {

    // 默认编码
    private static final String ENCODING_DEFAULT = "UTF-8";

    // 默认连接超时时间
    private static final int DEFAULT_CONNECT_TIMEOUT = 3 * 1000;

    // 默认会话超时时间
    private static final int DEFAULT_SOCKET_TIMEOUT = 5 * 1000;

    private HttpUtils() {
    }

    /**
     * GET请求
     */
    public static String doGet(String url) throws IOException {
        return doGet(url, DEFAULT_CONNECT_TIMEOUT);
    }

    /**
     * GET请求
     *
     * @param connectTimeout 连接超时时间
     */
    public static String doGet(String url, int connectTimeout) throws IOException {
        return doGet(url, connectTimeout, DEFAULT_SOCKET_TIMEOUT);
    }

    /**
     * GET请求
     *
     * @param socketTimeout 会话超时时间
     */
    public static String doGet(String url, int connectTimeout, int socketTimeout) throws IOException {
        return Request.Get(url)
                .connectTimeout(connectTimeout)
                .socketTimeout(socketTimeout)
                .execute()
                .returnContent()
                .asString(Charset.forName(ENCODING_DEFAULT));
    }

    /**
     * POST请求
     */
    public static String doPost(String url, Map<String, String> params) throws IOException {
        return doPost(url, params, DEFAULT_CONNECT_TIMEOUT);
    }

    /**
     * POST请求
     *
     * @param connectTimeout 连接超时时间
     */
    public static String doPost(String url, Map<String, String> params, int connectTimeout) throws IOException {
        return doPost(url, params, connectTimeout, DEFAULT_SOCKET_TIMEOUT);
    }

    /**
     * POST请求
     *
     * @param socketTimeout 会话超时时间
     */
    public static String doPost(String url, Map<String, String> params, int connectTimeout, int socketTimeout) throws IOException {
        List<NameValuePair> formParams = new ArrayList<>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            formParams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }

        return Request.Post(url)
                .connectTimeout(connectTimeout)
                .socketTimeout(socketTimeout)
                .body(new UrlEncodedFormEntity(formParams, ENCODING_DEFAULT))
                .execute()
                .returnContent()
                .asString();
    }

    /**
     * Post请求, 请求的数据为JSON格式
     */
    public static String doPostJson(String url, String content) throws IOException {
        return doPostJson(url, content, DEFAULT_CONNECT_TIMEOUT);
    }

    /**
     * Post请求, 请求的数据为JSON格式
     */
    public static String doPostJson(String url, String content, int connectTimeout) throws IOException {
        return doPostJson(url, content, connectTimeout, DEFAULT_SOCKET_TIMEOUT);
    }

    /**
     * Post请求, 请求的数据为JSON格式
     */
    public static String doPostJson(String url, String content, int connectTimeout, int socketTimeout) throws IOException {
        return Request.Post(url)
                .connectTimeout(connectTimeout)
                .socketTimeout(socketTimeout)
                .addHeader("Accept", "application/json")
                .bodyString(content, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent()
                .asString();
    }

}
