package io.github.miaoxinguo.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试 Json 工具类.
 */
public class TestJsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(TestJsonUtils.class);

    @Test
    public void testParseArray() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("abc");
        String s = JsonUtils.toJsonString(list);
        List result = JsonUtils.parseList(s, String.class);
        logger.debug("result is {}", result);
        Assert.assertEquals(list, result);
    }

    @Test
    public void testParseMap() throws IOException {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aa");
        map.put(2, "bb");
        String s = JsonUtils.toJsonString(map);
        Map result = JsonUtils.parseMap(s, Integer.class, String.class);

        Assert.assertEquals(map, result);
    }
}
