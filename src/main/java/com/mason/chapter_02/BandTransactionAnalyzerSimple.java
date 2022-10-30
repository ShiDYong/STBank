package com.mason.chapter_02;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author yongshi
 * @ClassName BandTransactionAnalyzerSimple
 * @Description 计算所有账单的总额：通过KISS(Keep It Short and Simple)原则，把运用程序
 *               的代码放在一个单独的类中
 * @date 2022/10/29 16:47
 */
public class BandTransactionAnalyzerSimple {
    //订单账单存放的路径
    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String... args) throws IOException {
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        //通过一行一行的读取方式
        final List<String> lines = Files.readAllLines(path);
        //这种方式是通过字节流
        final byte[] allBytes = Files.readAllBytes(path);
        //将字节流转化为字符串并指定字符
        String content = new String(allBytes, "utf-8");
        //输出打印出来
        System.out.println("content = \n" + content);
        double total = 0d;
        //以下是计算所有账单的总额
        for (java.lang.String line : lines) {
            //根据CSV的文件格式用逗号分隔，读取每一行的数据
            final java.lang.String[] columns = line.split(",");
            //根据文件格式数字金额是一般是第二个读取出来并将金额解析成double类型
            final double amount = Double.parseDouble(columns[1]);
            //进行累加操作
            total += amount;

        }
        System.out.println("The total for all transactions is " + total);

        double totalMonth = 0d;
        int i = 0;
        //以下是计算一月份账单有jd多少笔交易，每个交易的总额度是多少，可以直接利用之前的部分代码
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (String line : lines) {
            final String[] columns = line.split(",");
            //然后取出每行数据日期出来
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            //判断日期计算1月份的金额
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                totalMonth += amount;
                i++;
            }

        }
        System.out.println("The total for all transactions in January is " + totalMonth + " The total of " + i + " transactions took place in January");

        //如果要统计出1-12月每个月的交易总额是多少的方式：可以利用上一部分的代码；
        for (String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            //统计每个月的交易总额


        }

        /**
         * 通过以上实现的需求分析这个主类有多个职责，它可以分解为：
         *      1.读取输入；
         *      2.用指定的格式解析输入；
         *      3.处理结果；
         *      4.返回结果汇总；
         *  SRP(Single Responsibility Principle)单一职责：一个类负责一个单独的功能，一个类更改的原因只有一个
         *  因此SRP通常用于类和方法，遵循它有助于编写易于管理和维护的代码；
         *  针对上面方法出现的问题：我们将进行重构，很自然是将CSV文件解析逻辑提取到一个单独的类中，这样就可以
         *  处理不同的文件时重用它。
         *
         *
         *
         *
         */



    }
}
