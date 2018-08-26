package io.github.miaoxinguo.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import io.github.miaoxinguo.common.util.DateUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class TestDateUtils {

    @Test
    public void testToString() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime now = LocalDateTime.of(date, time);

        System.out.println(DateUtils.toString(date));
        System.out.println(DateUtils.toString(time));
        System.out.println(DateUtils.toString(now));
    }


    @Test
    public void testToStartString() {
        LocalDate date = LocalDate.now();
        System.out.println(DateUtils.toStartString(date));
    }

    @Test
    public void testToEndString() throws Exception {
        LocalDate date = LocalDate.now();
        System.out.println(DateUtils.toEndString(date));
    }

    @Test
    public void testParse() {
        String dateStr = "2000-12-22";
        String timeStr = "12:12:12";
        String dateTimeStr = "2000-12-22 12:12:12";

        LocalDate date = LocalDate.of(2000, 12, 22);
        LocalTime time = LocalTime.of(12, 12, 12);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Assert.assertEquals(date, DateUtils.parseDate(dateStr));
        Assert.assertEquals(time, DateUtils.parseTime(timeStr));
        Assert.assertEquals(dateTime, DateUtils.parseDateTime(dateTimeStr));
    }

    @Test
    public void testParseDate() {
        Date oldDate = new Date();
        LocalDateTime newDate = DateUtils.parseDateTime(oldDate);
        System.out.println(newDate);
    }

    @Test
    public void toGmtString() {
        System.out.println(DateUtils.toGmtString(LocalDateTime.now()));
    }

}