package com.mason.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * @author yongshi
 * @date 2022/10/30 11:38
 * @Description 通过使用BankStatementProcessor类将计算方法进行提取的方法后
 *             类的方法，重新处理银行交易列表
 */
public class BankStatementAnalyzerOld {
    private static final String RESOURCES = "src/main/resources/";
    //引入CSV解析类的
    private static final BankStatementCSVParserOld bankStatementCSVParser = new BankStatementCSVParserOld();

    public static void main(String[] args) throws IOException {
        final String fileName = "bank-data-simple.csv";
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
       //将文件解析
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);


    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor){

        System.out.println("The Total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The Total for all transaction in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The Total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));


    }



}
