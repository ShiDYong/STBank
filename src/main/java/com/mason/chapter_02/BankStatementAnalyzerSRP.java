package com.mason.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yongshi
 * @date 2022/10/29 23:36
 * @Description 将计算交易总额和每个月交易总额方法：通过单一职责进行实现
 * 即将BankTransActionAnalyzerSimple进行重构
 */
public class BankStatementAnalyzerSRP {

    private final static String RESOURCES = "src/main/resources/";

    public static void main(final String[] args) throws IOException {
        final BankStatementCSVParserOld bankStatementCSVParser = new BankStatementCSVParserOld();
        final String fileName = "bank-data-simple.csv";
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);

        System.out.println("the total for all transaction is " + calculateTotalAmount(bankTransactions));
        System.out.println("transaction in January  " + selectInMonth(bankTransactions, Month.JANUARY));

    }


    /**
     * 使用的老的方法实现计算交易总额
     * @param bankTransactions
     * @return
     */
    private static double calculateTotalAmountOld(List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();

        }
        return total;
    }


    /**
     * 使用的老的方法计算一月份的交易总额
     * @param bankTransactions
     * @param month
     * @return
     */
    private static List<BankTransaction> selectInMonthOld(List<BankTransaction> bankTransactions, Month month) {
        List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }


    /**
     * 使用Java8的stream快速处理数据，通过把计算交易总额方法拿出来
     *
     * @param bankTransactions
     * @return
     */
    private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
    }


    /**
     * 使用Java8的stream快速处理数据，计算每个月的交易总额方法
     *
     * @param bankTransactions
     * @return
     */
    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        return bankTransactions.stream().filter(bankTransaction -> month.equals(bankTransaction.getDate().getMonth())).collect(Collectors.toList());
    }

    /**
     * 这里仍然有一个问题是：负责执行计算的逻辑代码目前声明成了内部静态方法，这是内聚性差的一个例子，因为该类中声明的
     * 计算方法与解析或报告没有直接关系，需要进行提取操作；内聚主要关注于事物是怎么联系在一起的，更准确的的说，内聚衡量了一个类或者方法的职责关联的有多强
     * 换句话说，有多少功能是属于一起的？这是一种帮助你分析软件复杂性的方法，你想要实现高内聚，这意味着他人更容易定位、理解和使用代码；
     * 内聚的概念是运用类上的(类级别)，但也是可以到方法上(方法级别的内聚)
     */


}
