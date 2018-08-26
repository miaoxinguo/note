package io.github.miaoxinguo.common.util;

import java.io.IOException;

import org.junit.Test;

/**
 *
 */
public class TestHttpUtils {
    
    @Test
    public void testGet() throws IOException {
        String url = "http://www.baidu.com";
        System.out.println(HttpUtils.doGet(url));
    }
}
