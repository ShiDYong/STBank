package com.mason.chapter_02;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * JDK1.8后的日期和时间API常用的方法测试
 * 文章的链接：https://mp.weixin.qq.com/s?__biz=MzI0MTUwOTgyOQ==&mid=2247491866&idx=1&sn=f33a4dc680f031891a4cf3d43459aff5&chksm=e908d5b0de7f5ca6392d5aba0750b1ab76d75739d682a31f5b7e0464d49e3dbfc67f8a1fd913&cur_album_id=1696358010555547649&scene=189#wechat_redirect
 */
public class JSR310Test {

    /**
     * 在JDK 8之前，Java使用java.util.TimeZone来表示时区。而在JDK 8里分别使用了ZoneId表示时区，ZoneOffset表示UTC的偏移量
     * 实际开发中最好是使用时区而非偏移量。ZoneId在系统内是唯一的，它共包含三种类型的ID：
     * 最简单的ID类型：ZoneOffset，它由'Z'和以'+'或'-'开头的id组成。如：Z、+18:00、-18:00
     * 另一种类型的ID是带有某种前缀形式的偏移样式ID，例如'GMT+2'或'UTC+01:00'。可识别的（合法的）前缀是'UTC'， 'GMT'和'UT'
     * 第三种类型是基于区域的ID（推荐使用）。基于区域的ID必须包含两个或多个字符，且不能以'UTC'、'GMT'、'UT' '+'或'-'开头。
     * 基于区域的id由配置定义好的，如Europe/Paris
     * <p>
     * 在JSR 310日期时间体系了，一共有三个API可用于表示日期时间：
     * LocalDateTime：本地日期时间
     * OffsetDateTime：带偏移量的日期时间
     * ZonedDateTime：带时区的日期时间
     */
    @Test
    public void test01() {
        //获取当前的日期
        LocalDate now = LocalDate.now();
        //获取当前的时间
        LocalTime time = LocalTime.now();
        //获取本地日期时间
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime max = LocalDateTime.MAX;
        LocalDateTime min = LocalDateTime.MIN;
        System.out.println(max.getYear()+"-"+max.getMonthValue()+"-"+max.getDayOfMonth());
        System.out.println(min.getYear()+"-"+min.getMonthValue()+"-"+min.getDayOfMonth());
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("now = " + now);
        System.out.println("time = " + time);
        System.out.println("dateTime = " + dateTime);


    }

    /**
     * LocalDateTime常用的构造
     */
    @Test
    public void test02(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时区的本地时间：" + now);
        System.out.println("当前时区的本地时间：" + LocalDateTime.of(LocalDate.now(),LocalTime.now()));
        //最后一个构造传入了ZoneId，并不是说LocalDateTime和时区有关了，而是告诉说这个Local指的是纽约
        System.out.println("纽约时区的本地时间：" + LocalDateTime.now(ZoneId.of("America/New_York")));


    }

    /**
     * 日期之间常用的计算
     */
    @Test
    public void test03(){
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println("now = " + now);
        //加3天
        LocalDateTime after = now.plusDays(3);
        //减少4小时
        after = after.plusHours(-4); //相当now.minusHours(4)
        //计算时间差
        Period period = Period.between(now.toLocalDate(), after.toLocalDate());
        System.out.println("相差天数：" +period.getDays());

        //相差小时
        Duration duration = Duration.between(now.toLocalTime(), after.toLocalTime());
        System.out.println("相差小时的数：" + duration.toHours());

    }

    /**
     * LocalDateTime的格式化
     */
    @Test
    public void test04(){
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println("格式化输出：" + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT).format(now));
        String dateTimeStrParam = "2022-11-01 10:30:00";
        System.out.println("解析后输出：" + LocalDateTime.parse(dateTimeStrParam,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US)));

    }

    /**
     * OffsetDateTime是一个带有偏移量的日期时间类型。
     * 存储有精确到纳秒的日期时间，以及偏移量。
     * 可以简单理解为 OffsetDateTime = LocalDateTime + ZoneOffset
     * OffsetDateTime、ZonedDateTime和Instant它们三都能在时间线上以纳秒精度存储一个瞬间（请注意：LocalDateTime是不行的），
     * 也可理解某个时刻。OffsetDateTime和Instant可用于模型的字段类型，
     * 因为它们都表示瞬间值并且还不可变，所以适合网络传输或者数据库持久化
     * ZonedDateTime不适合网络传输/持久化，因为即使同一个ZoneId时区，不同地方获取到瞬时值也有可能不一样
     */
    @Test
    public void test05(){
        OffsetDateTime max = OffsetDateTime.MAX;
        OffsetDateTime min = OffsetDateTime.MIN;
        System.out.println("OffsetDate的最大值：" + max);
        System.out.println("OffsetDate的最小值：" + min);
        System.out.println(max.getOffset()+"-"+max.getYear()+"-" + max.getMonthValue()+"-" + max.getDayOfMonth());
        System.out.println(max.getOffset()+"-"+min.getYear()+"-" + min.getMonthValue()+"-" + min.getDayOfMonth());


        System.out.println("当前位置偏移量的本地时间：" + OffsetDateTime.now());
        System.out.println("偏移量-4的本地时间：" + OffsetDateTime.of(LocalDateTime.now(),ZoneOffset.of("-4")));
        System.out.println("纽约时间的本地时间：" + OffsetDateTime.now(ZoneId.of("America/New_York")));

        OffsetDateTime now = OffsetDateTime.now(ZoneId.systemDefault());
        System.out.println("格式化输出（本地化输出，中文环境）：" + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT).format(now));

        String dateTimeStrParam = "2021-01-17T18:00:00+07:00";
        System.out.println("解析后输出：" + OffsetDateTime.parse(dateTimeStrParam));

        Instant instant = Instant.now();
        System.out.println("instant = " + instant);
    }
}
