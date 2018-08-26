package io.github.miaoxinguo.common.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import org.apache.commons.lang3.SerializationException;

/**
 * Json 工具类 - Jackson 实现版本
 *
 * Jackson 所有异常转为 apache common 的 SerializationException 抛出， 由 mvc 框架统一处理
 */
@SuppressWarnings(value = {"unused", "WeakerAccess"})
public final class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        /*
         * 该特性决定parser将是否允许解析使用Java/C++ 样式的注释（包括'/'+'*' 和'//' 变量）。
         * 由于JSON标准说明书上面没有提到注释是否是合法的组成，所以这是一个非标准的特性；
         * 尽管如此，这个特性还是被广泛地使用。
         *
         * 该属性默认是false
         */
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

        /*
         * 这个特性决定parser是否将允许使用非双引号属性名字， （这种形式在Javascript中被允许，但是JSON标准说明书中没有）。
         * 由于JSON标准上需要为属性名称使用双引号，所以这也是一个非标准特性，默认是false的。
         */
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        /*
         * 该特性决定parser是否允许单引号来包住属性名称和字符串值。默认是false
         */
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        /*
         * 该特性决定parser是否允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符）。
         * 如果该属性关闭，则如果遇到这些字符，则会抛出异常。
         * JSON标准说明书要求所有控制符必须使用引号，因此这是一个非标准的特性。 默认是false。
         */
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    private JsonUtils() {
    }

    /**
     * 对象转json字符串
     */
    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    /**
     * Json字符串转对象
     */
    public static <T> T parseObject(String text, Class<T> clazz) {
        try {
            return objectMapper.readValue(text, clazz);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    /**
     * 将 JsonArray 转换为对应的List
     */
    public static <T> List<T> parseList(String text, Class<T> clazz) {
        JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, clazz);
        try {
            return objectMapper.readValue(text, type);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    /**
     * 转为Map
     */
    public static <K, V> Map<K, V> parseMap(String text, Class<K> keyClass, Class<V> valueClass) {
        MapType mapType = objectMapper.getTypeFactory().constructMapType(Map.class, keyClass, valueClass);
        try {
            return objectMapper.readValue(text, mapType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
