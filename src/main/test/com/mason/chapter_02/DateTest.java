package com.mason.chapter_02;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Java时间和日期类API测试
 */
public class DateTest {


    /**
     * 显示JDK中日期：CST、GMT、本地时间的显示
     */
    @Test
    public void test01(){
        Date cuurDate = new Date();
        //显示的标准的UTC时间：CST就代表了偏移量+0800）
        System.out.println(cuurDate.toString());
        //转换为当地时间，根据本地时区显示的时间格式，方法弃用
        System.out.println(cuurDate.toLocaleString());
        //获取格林尼治时间，可以看到它是凌晨3点（北京时间是上午11点哦）方法弃用
        System.out.println(cuurDate.toGMTString());
    }

    /**
     * 如何实现通过北京时间转换为纽约时间
     */
    @Test
    public void test02(){
        //设置日期的显示格式
        String patternDate = "yyyy-MM-dd- HH:mm:ss";
        //获取当前的北京时间
        Date bjDate = new Date();
        //获取当前纽约时间：TimeZone:时区名称
        TimeZone timeZoneOfNewYork = TimeZone.getTimeZone("America/New_York");
        //根据北京时间转换为纽约时间
        SimpleDateFormat newYorkDateFormat = new SimpleDateFormat(patternDate);
        newYorkDateFormat.setTimeZone(timeZoneOfNewYork);
        //两个时间表示的应该是同一时刻，也就是常说的时间戳值是相等的
        System.out.println("北京时间为：" + new SimpleDateFormat(patternDate).format(bjDate));
        System.out.println("纽约时间为：" + newYorkDateFormat.format(bjDate));

        //用Java程序把所有可用的zoneId打印出来
        String[] iDs = TimeZone.getAvailableIDs();
        System.out.println("可用的zoneId总数：" + iDs.length);
        //循环打印出来
        for (String iD : iDs) {
            System.out.println(iD);
        }



    }

    /**
     * 测试设置默认时区，具体对应的场景：
     * 一般来说，JVM在哪里跑，默认时区就是哪。对于国内程序员来讲，一般只会接触到东八区，
     * 也就是北京时间（本地时间）。随着国际合作越来越密切，很多时候需要日期时间国际化处理，
     * 举个很实际的例子：同一份应用在阿里云部署、在AWS（海外）上也部署一份供海外用户使用，
     * 此时同一份代码部署在不同的时区了，怎么破？倘若时区不同，那么势必影响到程序的运行结果，
     * 很容易带来计算逻辑的错误，很可能就乱套了。Java让我们有多种方式可以手动设置/修改默认时区：
     * API方式：强制将时区设为北京时区TimeZone.setDefault(TimeZone.getDefault().getTimeZone("GMT+8"));
     * JVM参数方式：-Duser.timezone=GMT+8
     * 运维设置方式：将操作系统主机时区设置为北京时区，这是推荐方式，可以完全对开发者无感，也方便了运维统一管理
     */
    @Test
    public void test03(){
        System.out.println(TimeZone.getTimeZone("GMT+08:00").getID());
        System.out.println(TimeZone.getDefault().getID());
        // 纽约时间，值得注意的是，这里只能用GMT+08:00，而不能用UTC+08:00
        System.out.println(TimeZone.getTimeZone("GMT-05:00").getID());
        System.out.println(TimeZone.getTimeZone("America/New_York").getID());

    }


    @Test
    public void test04() throws ParseException {
        String patterStr = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(patterStr);

        String birthdayStr = "1988-09-11";
        // 字符串 -> Date -> 字符串
        Date birthday = dateFormat.parse(birthdayStr);
        long birthdayTimestamp = birthday.getTime();
        System.out.println("老王的生日是：" + birthday);
        System.out.println("老王的生日的时间戳是：" + birthdayTimestamp);

        System.out.println("==============程序经过一番周转，我的同时 方法入参传来了生日的时间戳=============");
        // 字符串 -> Date -> 时间戳 -> Date -> 字符串
        birthday = new Date(birthdayTimestamp);
        System.out.println("老王的生日是：" + birthday);
        System.out.println("老王的生日的时间戳是：" + dateFormat.format(birthday));
    }


    /**
     * 读取字符串为Date类型的：
     * 对于字符串形式的日期时间，一般只有指定时期才有意义，也就是说字符串+时区才更明确
     * 当然平时在国内开发默认都是用北京时间，但是一般开发业务涉及国外业务，国外接口调用国内的接口
     * 就要格外注意
     */
    @Test
    public void test05() throws ParseException {
        String patterStr = "yyyy-MM-dd HH:mm:ss";
        //字符串形式的日期
        String strDate = "2022-10-31 15:45:45";
        //SimpleDateFormat格式化
        SimpleDateFormat timeFormat = new SimpleDateFormat(patterStr);
        System.out.println("格式化器用的时间是：" + timeFormat.getTimeZone().getID());
        Date date = timeFormat.parse(strDate);
        System.out.println("date = " + date);

        /**
         *Java中对Date类型的输入输出/格式化，推荐使用DateFormat而非用其toString()方法。
         *DateFormat是一个时间格式化器抽象类，SimpleDateFormat是其具体实现类，
         * 用于以语言环境敏感的方式格式化和解析日期。它允许格式化(日期→文本)、解析(文本→日期)和规范化。
         * 需要注意的点：
         * SimpleDateFormat并非线程安全类，使用时请务必注意并发安全问题
         * 若使用SimpleDateFormat去格式化成非本地区域（默认Locale）的话，那就必须在构造的时候就指定好，如Locale.US
         * 对于Date类型的任何格式化、解析请统一使用SimpleDateFormat
         *
         *
         */
        String patternStr = "G GG GGGGG E EE EEEEE a aa aaaaa";
        Date currDate = new Date();

        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓中文地区模式↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        System.out.println("====================Date->String====================");
        DateFormat dateFormat = new SimpleDateFormat(patternStr, Locale.CHINA);
        System.out.println(dateFormat.format(currDate));

        System.out.println("====================String->Date====================");
        String dateStrParam = "公元 公元 公元 星期六 星期六 星期六 下午 下午 下午";
        System.out.println(dateFormat.parse(dateStrParam));

        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓英文地区模式↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        System.out.println("====================Date->String====================");
        dateFormat = new SimpleDateFormat(patternStr, Locale.US);
        System.out.println(dateFormat.format(currDate));

        System.out.println("====================String->Date====================");
        dateStrParam = "AD ad bC Sat SatUrday sunDay PM PM Am";
        System.out.println(dateFormat.parse(dateStrParam));


    }




}
