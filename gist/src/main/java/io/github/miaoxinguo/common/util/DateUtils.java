package io.github.miaoxinguo.common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间工具类
 */
@SuppressWarnings("WeakerAccess")
public final class DateUtils {

    /**
     * 默认使用的日期、时间格式
     */
    private static final String DEFAULT_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_FORMAT_DATE = "yyyy-MM-dd";
    private static final String DEFAULT_FORMAT_TIME = "HH:mm:ss";

    private static final DateTimeFormatter FORMATTER_DATETIME = DateTimeFormatter.ofPattern(DEFAULT_FORMAT_DATETIME);
    private static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern(DEFAULT_FORMAT_DATE);
    private static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern(DEFAULT_FORMAT_TIME);

    /**
     * 禁止创建实例
     */
    private DateUtils() {
    }

    /**
     * 日期时间转为默认格式的字符串
     */
    public static String toString(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER_DATETIME);
    }

    /**
     * 日期时间转为默认格式的字符串
     */
    public static String toString(LocalDate date) {
        return date.format(FORMATTER_DATE);
    }

    /**
     * 日期时间转为默认格式的字符串
     */
    public static String toString(LocalTime time) {
        return time.format(FORMATTER_TIME);
    }

    /**
     * 日期对象转为当天的开始时间字符串
     *
     * @param date 日期
     * @return 日期时间字符串 yyyy-MM-dd 00:00
     */
    public static String toStartString(LocalDate date) {
        return toString(LocalDateTime.of(date, LocalTime.MIN));
    }

    /**
     * 日期对象转为当天的最晚时间字符串
     *
     * @param date 日期
     * @return 日期时间字符串 yyyy-MM-dd 23:59:59.999999999
     */
    public static String toEndString(LocalDate date) {
        return toString(LocalDateTime.of(date, LocalTime.MAX));
    }

    /**
     * Date对象转LocalDateTime对象
     */
    public static LocalDateTime parseDateTime(java.util.Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT_DATETIME);
        String s = format.format(date);
        return DateUtils.parseDateTime(s);
    }

    /**
     * 字符串转日期时间对象
     *
     * @param text yyyy-MM-dd HH:mm:ss格式字符串
     */
    public static LocalDateTime parseDateTime(String text) {
        return LocalDateTime.parse(text, FORMATTER_DATETIME);
    }

    /**
     * 字符串转日期对象
     *
     * @param text yyyy-MM-dd格式字符串
     */
    public static LocalDate parseDate(String text) {
        return LocalDate.parse(text, FORMATTER_DATE);
    }

    /**
     * 字符串转时间对象
     *
     * @param text HH:mm:ss格式字符串
     */
    public static LocalTime parseTime(String text) {
        return LocalTime.parse(text, FORMATTER_TIME);
    }

    /**
     * LocalDateTime转GMT时间
     */
    public static String toGmtString(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME.withZone(ZoneId.of("GMT"));
        return formatter.format(time.toInstant(ZoneOffset.MIN));
    }

}
